package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.assignment.AssignmentRequestDTO;
import com.example.elearningplatform.dto.assignment.AssignmentResponseDTO;
import com.example.elearningplatform.mapper.AssignmentMapper;
import com.example.elearningplatform.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository repository;
    private final AssignmentMapper mapper;

    public AssignmentResponseDTO create(AssignmentRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }
}
