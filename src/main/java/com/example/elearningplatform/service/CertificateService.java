package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.certificate.CertificateRequestDTO;
import com.example.elearningplatform.dto.certificate.CertificateResponseDTO;
import com.example.elearningplatform.mapper.CertificateMapper;
import com.example.elearningplatform.model.Certificate;
import com.example.elearningplatform.model.Course;
import com.example.elearningplatform.model.User;
import com.example.elearningplatform.repository.CertificateRepository;
import com.example.elearningplatform.repository.CourseRepository;
import com.example.elearningplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CertificateMapper certificateMapper;

    public CertificateResponseDTO create(CertificateRequestDTO dto) {

        // 1. Загружаем реальные сущности по ID
        User student = (User) userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));

        Course course = courseRepository.findById(Math.toIntExact(dto.getCourseId()))
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));

        // 2. Создаём сертификат вручную (или через builder)
        Certificate certificate = Certificate.builder()
                .student(student)
                .course(course)
                .certificateUrl(dto.getCertificateUrl())
                .build();
        // issuedAt заполнится автоматически благодаря @PrePersist

        // 3. Сохраняем
        Certificate saved = certificateRepository.save(certificate);

        // 4. Возвращаем DTO
        return certificateMapper.toResponseDTO(saved);
    }
}