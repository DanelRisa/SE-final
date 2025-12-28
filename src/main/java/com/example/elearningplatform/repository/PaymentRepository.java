package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
