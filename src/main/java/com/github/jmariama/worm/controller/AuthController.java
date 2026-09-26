package com.github.jmariama.worm.controller;

import com.github.jmariama.worm.domain.auth.LoginRequest;
import com.github.jmariama.worm.domain.auth.LoginResponse;
import com.github.jmariama.worm.services.AuthenticationService;
import com.github.jmariama.worm.domain.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //rest endpoints 'live' here!
@RequestMapping("/library/auth") //abstracts urls
@RequiredArgsConstructor

public class AuthController {

    private final AuthenticationService authService;

    //login user
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.signInUser(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    //register a new user
    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        authService.registerUser(registerRequest);
        return ResponseEntity.ok().build();
    }
}