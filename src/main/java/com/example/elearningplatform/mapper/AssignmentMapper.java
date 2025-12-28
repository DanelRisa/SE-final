package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.assignment.AssignmentRequestDTO;
import com.example.elearningplatform.dto.assignment.AssignmentResponseDTO;
import com.example.elearningplatform.model.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    @Mapping(source = "lessonId", target = "lesson.id")
    Assignment toEntity(AssignmentRequestDTO dto);

    @Mapping(source = "lesson.id", target = "lessonId")
    @Mapping(source = "deadline", target = "deadline", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    AssignmentResponseDTO toResponseDTO(Assignment assignment);
}