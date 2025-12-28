package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.courseCategory.CourseCategoryRequestDTO;
import com.example.elearningplatform.dto.courseCategory.CourseCategoryResponseDTO;
import com.example.elearningplatform.model.CourseCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseCategoryMapper {
    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "categoryId", target = "category.id")
    CourseCategory toEntity(CourseCategoryRequestDTO dto);

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "category.id", target = "categoryId")
    CourseCategoryResponseDTO toResponseDTO(CourseCategory cc);
}