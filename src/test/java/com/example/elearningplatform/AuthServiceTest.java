package com.example.elearningplatform;

import com.example.elearningplatform.config.JwtUtil;
import com.example.elearningplatform.dto.auth.AuthRequestDTO;
import com.example.elearningplatform.dto.auth.AuthResponseDTO;
import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.UserRepository;

import com.example.elearningplatform.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JwtUtil jwtUtil;



    @InjectMocks
    private AuthService authService;

    @Test
    void register_Success() {
        UserRequestDTO dto = new UserRequestDTO("dias@narxoz.kz", "password", "dias", "abdulaziz", User.Role.STUDENT);
        when(userRepository.existsByEmail(dto.getEmail())).thenReturn(false);

        authService.register(dto);

        log.info("Registered user: {}", dto);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void login_Success() {
        AuthRequestDTO dto = new AuthRequestDTO("user@test.com", "password");
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword("hashed_pass");

        when(userRepository.findByEmail(dto.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password", "hashed_pass")).thenReturn(true);
        when(jwtUtil.generateToken(user)).thenReturn("mock_token");

        AuthResponseDTO response = authService.login(dto);

        log.info("Login response: {}", response);
        assertNotNull(response.getToken());
        assertEquals("mock_token", response.getToken());
    }
}