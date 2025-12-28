package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository  extends JpaRepository<Assignment, Integer> {
}
