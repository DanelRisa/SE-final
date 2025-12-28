package com.example.elearningplatform.dto.notification;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponseDTO {
    private Long id;
    private Long userId;
    private String message;
    private Boolean isRead;
    private String createdAt;
}
