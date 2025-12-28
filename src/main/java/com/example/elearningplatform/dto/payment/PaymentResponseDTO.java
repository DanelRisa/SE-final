package com.example.elearningplatform.dto.payment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDTO {
    private Long id;
    private Long userId;
    private Long courseId;
    private Double amount;
    private String paymentStatus;
    private String paymentDate;
}
