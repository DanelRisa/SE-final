package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.course.CourseRequestDTO;
import com.example.elearningplatform.dto.course.CourseResponseDTO;
import com.example.elearningplatform.mapper.CourseMapper;
import com.example.elearningplatform.model.Course;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.CourseRepository;
import com.example.elearningplatform.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final UserRepository userRepository;

    public CourseResponseDTO create(CourseRequestDTO dto) {
        Course course = courseMapper.toEntity(dto);
        course.setTeacher((User) userRepository.findById(dto.getTeacherId()).orElseThrow());
        return courseMapper.toResponseDTO(courseRepository.save(course));
    }

    public List<CourseResponseDTO> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}