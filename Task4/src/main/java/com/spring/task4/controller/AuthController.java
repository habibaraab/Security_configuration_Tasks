package com.spring.task4.controller;


import com.spring.task4.DTO.userRequest;
import com.spring.task4.Repository.UserRepo;
import com.spring.task4.model.Role;
import com.spring.task4.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String register(@RequestBody userRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(
                        Role.builder()
                                .name("USER")
                                .id(1L).build()
                ))
                .build();

        userRepository.save(user);
        return "User registered successfully!";
    }


    @PostMapping("/login")
    public String login(@RequestBody userRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return "Login successful for user: " + auth.getName();
    }

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint!";
    }
}