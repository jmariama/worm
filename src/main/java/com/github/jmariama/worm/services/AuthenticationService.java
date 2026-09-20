package com.github.jmariama.worm.services;

import com.github.jmariama.worm.domain.auth.LoginRequest;
import com.github.jmariama.worm.domain.auth.LoginResponse;
import com.github.jmariama.worm.domain.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    void registerUser(RegisterRequest registerRequest);
    LoginResponse signInUser(LoginRequest loginRequest);
}