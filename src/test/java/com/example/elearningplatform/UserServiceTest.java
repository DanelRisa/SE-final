package com.example.elearningplatform;
import com.example.elearningplatform.dto.auth.ChangePasswordRequestDTO;
import com.example.elearningplatform.mapper.UserMapper;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.UserRepository;
import com.example.elearningplatform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@Slf4j
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new User();
        mockUser.setId(1L);
        mockUser.setEmail("danelissuper@example.com");
        mockUser.setPassword("encoded_old_password");
        log.info("mockUser: {}", mockUser);
        Authentication auth = new UsernamePasswordAuthenticationToken(mockUser.getEmail(), null);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    void changePassword_Success() {
        ChangePasswordRequestDTO dto = new ChangePasswordRequestDTO("old_pass", "new_pass");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches("old_pass", "encoded_old_password")).thenReturn(true);
        when(passwordEncoder.encode("new_pass")).thenReturn("encoded_new_password");

        userService.changePassword(dto);
        log.info("Password changed successfully");
        verify(userRepository).save(mockUser);
        assertEquals("encoded_new_password", mockUser.getPassword());
    }

    @Test
    void changePassword_WrongOldPassword_ThrowsException() {
        ChangePasswordRequestDTO dto = new ChangePasswordRequestDTO("wrong_old", "new_pass");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

        log.info("Password changed successfully");
        assertThrows(RuntimeException.class, () -> userService.changePassword(dto));
    }

    @Test
    void blockUser_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        userService.blockUser(1L);

        log.info("User blocked successfully");
        assertEquals(User.Status.BLOCKED, mockUser.getStatus());
        verify(userRepository).save(mockUser);
    }
}