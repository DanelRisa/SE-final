package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.category.CategoryRequestDTO;
import com.example.elearningplatform.dto.category.CategoryResponseDTO;
import com.example.elearningplatform.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequestDTO dto);
    CategoryResponseDTO toResponseDTO(Category category);
}