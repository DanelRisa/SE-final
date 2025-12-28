package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.auth.AuthRequestDTO;
import com.example.elearningplatform.dto.auth.AuthResponseDTO;
import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.dto.user.UserResponseDTO;
import com.example.elearningplatform.service.AuthService;
import com.example.elearningplatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDTO dto) {
        authService.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO dto) {
        return authService.login(dto);
    }
}
