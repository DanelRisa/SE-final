package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
