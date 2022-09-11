package com.example.namegenerator.dto;

import com.example.namegenerator.dto.filter.Filter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputNotificationMessage {
    private String userName;
    private Filter filter;
}
