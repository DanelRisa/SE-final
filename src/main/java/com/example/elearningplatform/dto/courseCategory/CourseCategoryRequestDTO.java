package com.example.elearningplatform.dto.courseCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseCategoryRequestDTO {
    private Long courseId;
    private Long categoryId;
}