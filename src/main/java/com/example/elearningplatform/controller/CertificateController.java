package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.certificate.CertificateRequestDTO;
import com.example.elearningplatform.dto.certificate.CertificateResponseDTO;
import com.example.elearningplatform.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping
    public CertificateResponseDTO create(@RequestBody CertificateRequestDTO dto) {
        return certificateService.create(dto);
    }
}