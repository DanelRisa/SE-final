package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.review.ReviewRequestDTO;
import com.example.elearningplatform.dto.review.ReviewResponseDTO;
import com.example.elearningplatform.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "studentId", target = "student.id")
    Review toEntity(ReviewRequestDTO dto);

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    ReviewResponseDTO toResponseDTO(Review review);
}
