package com.github.jmariama.worm.services;

import com.github.jmariama.worm.domain.entities.UserEntity;
import com.github.jmariama.worm.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service //implementation of authentication service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        BCryptPasswordEncoder passowrdEncoder = new BCryptPasswordEncoder(); //encrypts user passwords

        //builds user entity
        UserEntity user = UserEntity.builder()
                .name(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .userPassword(passwordEncoder.encode(registerRequest.getPassword()))
                .created_at(LocalDateTime.now())
                .build();

        //saves user entity into data repository.
        userRepository.save(user);

    }

}
