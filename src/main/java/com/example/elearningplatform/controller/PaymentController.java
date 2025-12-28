package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.payment.PaymentRequestDTO;
import com.example.elearningplatform.dto.payment.PaymentResponseDTO;
import com.example.elearningplatform.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public PaymentResponseDTO pay(@RequestBody PaymentRequestDTO dto) {
        return paymentService.pay(dto);
    }
}
