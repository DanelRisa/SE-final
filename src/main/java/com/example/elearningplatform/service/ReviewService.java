package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.review.ReviewRequestDTO;
import com.example.elearningplatform.dto.review.ReviewResponseDTO;
import com.example.elearningplatform.mapper.ReviewMapper;
import com.example.elearningplatform.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    public ReviewResponseDTO create(ReviewRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }
}
