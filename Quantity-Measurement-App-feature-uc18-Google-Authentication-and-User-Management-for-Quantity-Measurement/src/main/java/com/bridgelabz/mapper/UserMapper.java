package com.bridgelabz.mapper;

import com.bridgelabz.dto.auth.RegisterRequestDTO;
import com.bridgelabz.entity.UserEntity;
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