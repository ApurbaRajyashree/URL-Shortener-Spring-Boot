package com.url.shortener.service;

import com.url.shortener.dto.LoginRequestDto;
import com.url.shortener.dto.UserRegisterRequestDto;
import com.url.shortener.security.jwt.JwtAuthenticationResponse;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface UserService {
    void registerUser(UserRegisterRequestDto registerRequestDto);
    JwtAuthenticationResponse login(LoginRequestDto loginRequestDto) throws UserPrincipalNotFoundException;
}
