package com.example.elearningplatform.repository;

import com.example.elearningplatform.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
