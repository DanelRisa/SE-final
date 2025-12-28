package com.example.elearningplatform.mapper;


import com.example.elearningplatform.dto.user.UserRequestDTO;
import com.example.elearningplatform.dto.user.UserResponseDTO;
import com.example.elearningplatform.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponseDTO(User user);
}