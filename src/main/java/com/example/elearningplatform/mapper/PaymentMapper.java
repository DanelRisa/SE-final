package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.payment.PaymentRequestDTO;
import com.example.elearningplatform.dto.payment.PaymentResponseDTO;
import com.example.elearningplatform.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "courseId", target = "course.id")
    Payment toEntity(PaymentRequestDTO dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "paymentDate", target = "paymentDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    PaymentResponseDTO toResponseDTO(Payment payment);
}