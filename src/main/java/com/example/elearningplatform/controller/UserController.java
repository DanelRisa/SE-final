package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.admin.AdminCreateUserDTO;
import com.example.elearningplatform.dto.auth.ChangePasswordRequestDTO;
import com.example.elearningplatform.dto.user.UpdateProfileDTO;
import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.dto.user.UserResponseDTO;
import com.example.elearningplatform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/profile")
    public UserResponseDTO updateProfile(@RequestBody UpdateProfileDTO dto) {
        return userService.updateProfile(dto);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestBody ChangePasswordRequestDTO dto) {
        userService.changePassword(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDTO create(@RequestBody AdminCreateUserDTO dto) {
        return userService.createByAdmin(dto);
    }

    @PutMapping("/{id}/block")
    @PreAuthorize("hasRole('ADMIN')")
    public void block(@PathVariable Long id) {
        userService.blockUser(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
