package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.assignment.AssignmentRequestDTO;
import com.example.elearningplatform.dto.assignment.AssignmentResponseDTO;
import com.example.elearningplatform.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
@PreAuthorize("hasRole('TEACHER')")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public AssignmentResponseDTO create(@RequestBody AssignmentRequestDTO dto) {
        return assignmentService.create(dto);
    }
}
