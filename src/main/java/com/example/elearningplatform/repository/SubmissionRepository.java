package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
