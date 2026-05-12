package com.bridgelabz.service.auth;

import com.bridgelabz.dto.auth.AuthResponseDTO;
import com.bridgelabz.dto.auth.LoginRequestDTO;
import com.bridgelabz.dto.auth.RegisterRequestDTO;
import com.bridgelabz.entity.UserEntity;
import com.bridgelabz.mapper.UserMapper;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.security.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    // REGISTER
    public AuthResponseDTO register(RegisterRequestDTO request) {

        UserEntity user = userMapper.toEntity(request);

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("USER");
        user.setProvider("LOCAL");

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }

    // LOGIN
    public AuthResponseDTO login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepository.findByEmail(
                request.getEmail()
        ).orElseThrow();

        String token = jwtService.generateToken(user.getEmail());

        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }
}