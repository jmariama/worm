package com.github.jmariama.worm.controller;

import com.github.jmariama.worm.services.AuthenticationService;
import com.github.jmariama.worm.services.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //rest endpoints 'live' here!
@RequestMapping("/library/auth") //abstracts urls
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/registerUser") // login will be appended authorization, allowing us to access login
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = authService.registerUser(registerRequest);

        if(registerResponse == null){
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad Credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok.builder();
    }
}