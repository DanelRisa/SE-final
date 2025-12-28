package com.example.elearningplatform.dto.course;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestDTO {
    private String title;
    private String description;
    private Double price;
    private Long teacherId;
    private String status;
}