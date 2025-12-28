package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.lesson.LessonRequestDTO;
import com.example.elearningplatform.dto.lesson.LessonResponseDTO;
import com.example.elearningplatform.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(source = "courseId", target = "course.id")
    Lesson toEntity(LessonRequestDTO dto);

    @Mapping(source = "course.id", target = "courseId")
    LessonResponseDTO toResponseDTO(Lesson lesson);
}