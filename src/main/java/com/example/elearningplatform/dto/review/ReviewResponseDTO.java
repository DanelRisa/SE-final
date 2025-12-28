package com.example.elearningplatform.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {
    private Long id;
    private Long courseId;
    private Long studentId;
    private Integer rating;
    private String comment;
    private String createdAt;
}