package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.enrollment.EnrollmentRequestDTO;
import com.example.elearningplatform.dto.enrollment.EnrollmentResponseDTO;
import com.example.elearningplatform.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    Enrollment toEntity(EnrollmentRequestDTO dto);

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "enrolledAt", target = "enrolledAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    EnrollmentResponseDTO toResponseDTO(Enrollment enrollment);
}