package com.example.springauth.presentation;

import com.example.springauth.presentation.dto.SignupRequestDto;
import com.example.springauth.presentation.dto.SignupResponseDto;
import com.example.springauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        return ResponseEntity.status(201)
                .body(authService.signup(signupRequestDto));
    }
}
