package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.lesson.LessonRequestDTO;
import com.example.elearningplatform.dto.lesson.LessonResponseDTO;
import com.example.elearningplatform.mapper.LessonMapper;
import com.example.elearningplatform.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public LessonResponseDTO create(LessonRequestDTO dto) {
        return lessonMapper.toResponseDTO(
                lessonRepository.save(lessonMapper.toEntity(dto))
        );
    }

    public List<LessonResponseDTO> getLessonsByCourseId(Long courseId) {
        return lessonRepository.findByCourseIdOrderByOrderIndexAsc(courseId)
                .stream()
                .map(lessonMapper::toResponseDTO)
                .toList();
    }

}