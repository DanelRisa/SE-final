package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.course.CourseRequestDTO;
import com.example.elearningplatform.dto.course.CourseResponseDTO;
import com.example.elearningplatform.model.Course;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "teacherId", target = "teacher.id")
    Course toEntity(CourseRequestDTO dto);

    @Mapping(source = "teacher.id", target = "teacherId")
    CourseResponseDTO toResponseDTO(Course course);
}
