package com.example.gateway.dto;

import com.example.gateway.dto.filter.Filter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {
    private String userName;
    private Filter filter;
}
