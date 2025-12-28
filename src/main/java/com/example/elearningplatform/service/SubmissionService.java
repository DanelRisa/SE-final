package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.submission.SubmissionRequestDTO;
import com.example.elearningplatform.dto.submission.SubmissionResponseDTO;
import com.example.elearningplatform.mapper.SubmissionMapper;
import com.example.elearningplatform.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository repository;
    private final SubmissionMapper mapper;

    public SubmissionResponseDTO submit(SubmissionRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }
}