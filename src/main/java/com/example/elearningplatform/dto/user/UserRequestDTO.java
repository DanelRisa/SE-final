package com.example.elearningplatform.dto.user;

import com.example.elearningplatform.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private User.Role role; // ADMIN, TEACHER, STUDENT
}
