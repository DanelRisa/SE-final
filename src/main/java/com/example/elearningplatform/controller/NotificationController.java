package com.example.elearningplatform.controller;

import com.example.elearningplatform.dto.notification.NotificationRequestDTO;
import com.example.elearningplatform.dto.notification.NotificationResponseDTO;
import com.example.elearningplatform.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public NotificationResponseDTO send(@RequestBody NotificationRequestDTO dto) {
        return notificationService.send(dto);
    }
}
