package com.example.elearningplatform;

import com.example.elearningplatform.config.JwtUtil;
import com.example.elearningplatform.controller.UserController;
import com.example.elearningplatform.dto.user.UpdateProfileDTO;
import com.example.elearningplatform.dto.user.UserResponseDTO;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;




@Slf4j
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private JwtUtil jwtUtil;

    @MockitoBean
    private UserDetailsService userDetailsService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void updateProfile_Returns200() throws Exception {
        UpdateProfileDTO dto = new UpdateProfileDTO("Danel", "Yerk", "danel@email.com");
        UserResponseDTO response = new UserResponseDTO(1L, "danel@email.com", "Danel", "Yerk", User.Role.STUDENT, User.Status.ACTIVE);

        when(userService.updateProfile(any(UpdateProfileDTO.class))).thenReturn(response);

        log.info("updateProfile");
        mockMvc.perform(put("/api/users/profile")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("danel@email.com"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deleteUser_Returns200() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
            log.info("deleteUser");

        verify(userService).deleteUser(1L);
    }
}