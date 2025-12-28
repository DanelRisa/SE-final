package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.certificate.CertificateRequestDTO;
import com.example.elearningplatform.dto.certificate.CertificateResponseDTO;
import com.example.elearningplatform.model.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    Certificate toEntity(CertificateRequestDTO dto);

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "issuedAt", target = "issuedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    CertificateResponseDTO toResponseDTO(Certificate certificate);
}