package com.example.springauth.presentation.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponseDto {
    private String email;
    private String username;

    public static SignupResponseDto toDto(String email, String username) {
        return new SignupResponseDto(email, username);
    }
}
