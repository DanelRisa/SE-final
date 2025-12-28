package com.example.elearningplatform.dto.payment;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDTO {
    private Long userId;
    private Long courseId;
    private Double amount;
    private String paymentStatus; // PENDING, COMPLETED, FAILED
}