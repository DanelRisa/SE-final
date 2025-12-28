package com.example.elearningplatform.dto.enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponseDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private Double progressPercentage;
    private String enrolledAt;
}