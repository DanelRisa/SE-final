package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.submission.SubmissionRequestDTO;
import com.example.elearningplatform.dto.submission.SubmissionResponseDTO;
import com.example.elearningplatform.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public SubmissionResponseDTO submit(@RequestBody SubmissionRequestDTO dto) {
        return submissionService.submit(dto);
    }
}
