package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
