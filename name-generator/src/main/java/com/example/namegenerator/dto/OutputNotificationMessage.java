package com.example.namegenerator.dto;

import com.example.namegenerator.dto.filter.Filter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutputNotificationMessage {
    private String userName;
    private LocalDateTime date;
    private String eventName;
    private String body;
}
