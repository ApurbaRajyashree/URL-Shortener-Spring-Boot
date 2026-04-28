package com.url.shortener.controller;


import com.url.shortener.dto.UserRegisterRequestDto;
import com.url.shortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequestDto registerRequestDto) {
        userService.registerUser(registerRequestDto);
        return ResponseEntity.ok("User Registered Successfully");
    }
}
