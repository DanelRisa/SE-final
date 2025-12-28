package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.review.ReviewRequestDTO;
import com.example.elearningplatform.dto.review.ReviewResponseDTO;
import com.example.elearningplatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ReviewResponseDTO create(@RequestBody ReviewRequestDTO dto) {
        return reviewService.create(dto);
    }
}
