package com.example.userservice.controller;

import com.example.userservice.dto.auth.AuthResponseDTO;
import com.example.userservice.dto.auth.LoginRequestDTO;
import com.example.userservice.dto.auth.RegisterRequestDTO;
import com.example.userservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // REGISTER
    @PostMapping("/register")
    public AuthResponseDTO register(
            @RequestBody RegisterRequestDTO request
    ) {

        return authService.register(request);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponseDTO login(
            @RequestBody LoginRequestDTO request
    ) {

        return authService.login(request);
    }
}