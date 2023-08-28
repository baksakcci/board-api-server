package com.example.springauth.service;

import com.example.springauth.domain.entity.Member;
import com.example.springauth.domain.infra.MemberRepository;
import com.example.springauth.presentation.dto.LoginRequestDto;
import com.example.springauth.presentation.dto.SignupRequestDto;
import com.example.springauth.presentation.dto.SignupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        Member member = Member.create(
            signupRequestDto.getEmail(),
            signupRequestDto.getPassword(),
            signupRequestDto.getUsername()
            );
        memberRepository.save(member);
        return SignupResponseDto.toDto(
            member.getEmail(),
            member.getUsername()
            );
    }

    public void login(LoginRequestDto loginRequestDto) {
        memberRepository.findByEmailAndPassword(
            loginRequestDto.getEmail(),
            loginRequestDto.getPassword()
        ).orElseThrow();

    }
}
