package com.example.demo.Notification;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDTO {

    private String message;

    private String type;

    private Long orderId;
}
