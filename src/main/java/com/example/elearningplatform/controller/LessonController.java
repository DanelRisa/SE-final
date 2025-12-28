package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.lesson.LessonRequestDTO;
import com.example.elearningplatform.dto.lesson.LessonResponseDTO;
import com.example.elearningplatform.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping("/lessons")
    @PreAuthorize("hasRole('TEACHER')")
    public LessonResponseDTO create(@RequestBody LessonRequestDTO dto) {
        return lessonService.create(dto);
    }

    @GetMapping("/courses/{courseId}/lessons")
    public List<LessonResponseDTO> getLessonsByCourse(@PathVariable Long courseId) {
        return lessonService.getLessonsByCourseId(courseId);
    }
}
