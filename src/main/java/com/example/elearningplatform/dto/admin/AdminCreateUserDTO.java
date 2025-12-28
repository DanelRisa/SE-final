package com.example.elearningplatform.dto.admin;

import lombok.Data;

@Data
public class AdminCreateUserDTO {
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
}