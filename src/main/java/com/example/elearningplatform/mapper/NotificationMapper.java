package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.notification.NotificationRequestDTO;
import com.example.elearningplatform.dto.notification.NotificationResponseDTO;
import com.example.elearningplatform.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(source = "userId", target = "user.id")
    Notification toEntity(NotificationRequestDTO dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    NotificationResponseDTO toResponseDTO(Notification notification);
}