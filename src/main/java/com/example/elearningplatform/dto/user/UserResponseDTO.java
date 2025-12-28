package com.example.elearningplatform.dto.user;


import com.example.elearningplatform.model.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private User.Role role;
    private User.Status status;
}
