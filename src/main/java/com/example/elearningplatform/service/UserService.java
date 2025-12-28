package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.admin.AdminCreateUserDTO;
import com.example.elearningplatform.dto.auth.ChangePasswordRequestDTO;
import com.example.elearningplatform.dto.user.UpdateProfileDTO;
import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.dto.user.UserResponseDTO;
import com.example.elearningplatform.mapper.UserMapper;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email).orElseThrow();
    }

    public void changePassword(ChangePasswordRequestDTO dto) {
        User user = getCurrentUser();

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }

    public UserResponseDTO updateProfile(UpdateProfileDTO dto) {
        User user = getCurrentUser();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());

        return userMapper.toResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO createByAdmin(AdminCreateUserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(User.Role.valueOf(dto.getRole()));
        user.setStatus(User.Status.ACTIVE);
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void blockUser(Long id) {
        User user = (User) userRepository.findById(id).orElseThrow();
        user.setStatus(User.Status.BLOCKED);
        userRepository.save(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponseDTO).toList();

    }
}
