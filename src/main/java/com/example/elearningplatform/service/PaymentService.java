package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.payment.PaymentRequestDTO;
import com.example.elearningplatform.dto.payment.PaymentResponseDTO;
import com.example.elearningplatform.mapper.PaymentMapper;
import com.example.elearningplatform.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    public PaymentResponseDTO pay(PaymentRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }
}
