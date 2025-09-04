package com.spring.task5.Controller;

import com.spring.task5.DTOS.AuthenticationResponse;
import com.spring.task5.DTOS.LoginRequest;
import com.spring.task5.DTOS.UserRequestDto;
import com.spring.task5.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {


    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest , @RequestParam Map<String,Object> claims) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRequestDto registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}