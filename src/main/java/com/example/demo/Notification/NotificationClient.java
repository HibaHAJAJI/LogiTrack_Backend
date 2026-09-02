package com.example.demo.Notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "notification-service", url = "${notification.service.url}")
public interface NotificationClient {

    @PostMapping("/api/notifications")
    NotificationDTO sendNotification(@RequestBody NotificationDTO notification);
}
