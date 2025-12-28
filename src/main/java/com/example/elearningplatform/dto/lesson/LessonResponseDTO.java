package com.example.elearningplatform.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Long courseId;
    private Integer orderIndex;
}
