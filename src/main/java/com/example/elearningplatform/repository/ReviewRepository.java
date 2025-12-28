package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
