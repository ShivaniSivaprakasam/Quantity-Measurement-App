package com.example.userservice.mapper;

import com.example.userservice.dto.auth.RegisterRequestDTO;
import com.example.userservice.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(RegisterRequestDTO dto) {

        return UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}