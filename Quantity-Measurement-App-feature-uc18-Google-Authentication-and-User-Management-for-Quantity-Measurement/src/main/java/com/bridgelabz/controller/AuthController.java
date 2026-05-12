package com.bridgelabz.controller;

import com.bridgelabz.dto.auth.AuthResponseDTO;
import com.bridgelabz.dto.auth.LoginRequestDTO;
import com.bridgelabz.dto.auth.RegisterRequestDTO;
import com.bridgelabz.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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