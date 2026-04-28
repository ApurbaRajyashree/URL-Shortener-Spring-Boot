package com.url.shortener.service;

import com.url.shortener.dto.UserRegisterRequestDto;

public interface UserService {
    void registerUser(UserRegisterRequestDto registerRequestDto);
}
