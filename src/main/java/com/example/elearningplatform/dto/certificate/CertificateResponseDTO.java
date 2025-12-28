package com.example.elearningplatform.dto.certificate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateResponseDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String issuedAt;
    private String certificateUrl;
}
