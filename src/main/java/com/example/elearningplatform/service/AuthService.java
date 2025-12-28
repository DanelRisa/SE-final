package com.example.elearningplatform.service;

import com.example.elearningplatform.config.JwtUtil;
import com.example.elearningplatform.dto.auth.AuthRequestDTO;
import com.example.elearningplatform.dto.auth.AuthResponseDTO;
import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.UserRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void register(UserRequestDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(User.Role.STUDENT);
        user.setStatus(User.Status.ACTIVE);

        System.out.println("User: " + user);
        userRepository.save(user);
        System.out.println("User is created");


    }

    public AuthResponseDTO login(AuthRequestDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
