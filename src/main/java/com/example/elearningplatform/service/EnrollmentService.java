package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.enrollment.EnrollmentRequestDTO;
import com.example.elearningplatform.dto.enrollment.EnrollmentResponseDTO;
import com.example.elearningplatform.mapper.EnrollmentMapper;
import com.example.elearningplatform.model.Enrollment;
import com.example.elearningplatform.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentResponseDTO enroll(EnrollmentRequestDTO dto) {
        Enrollment enrollment = enrollmentMapper.toEntity(dto);
        enrollment.setProgressPercentage(0.0);
        return enrollmentMapper.toResponseDTO(enrollmentRepository.save(enrollment));
    }
}