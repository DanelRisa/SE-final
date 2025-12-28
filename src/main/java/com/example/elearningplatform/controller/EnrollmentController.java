package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.enrollment.EnrollmentRequestDTO;
import com.example.elearningplatform.dto.enrollment.EnrollmentResponseDTO;
import com.example.elearningplatform.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentResponseDTO enroll(@RequestBody EnrollmentRequestDTO dto) {
        return enrollmentService.enroll(dto);
    }
}
