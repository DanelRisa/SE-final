package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.notification.NotificationRequestDTO;
import com.example.elearningplatform.dto.notification.NotificationResponseDTO;
import com.example.elearningplatform.mapper.NotificationMapper;
import com.example.elearningplatform.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    public NotificationResponseDTO send(NotificationRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }
}
