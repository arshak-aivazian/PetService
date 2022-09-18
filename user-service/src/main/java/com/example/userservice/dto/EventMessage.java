package com.example.userservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventMessage {
    private String userName;
    private LocalDateTime date;
    private String eventName;
    private String body;
}
