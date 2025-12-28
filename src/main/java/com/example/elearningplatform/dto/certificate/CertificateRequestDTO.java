package com.example.elearningplatform.dto.certificate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateRequestDTO {
    private Long studentId;
    private Long courseId;
    private String certificateUrl;
}