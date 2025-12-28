package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer> {
    void deleteById(Long id);
}
