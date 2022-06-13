package com.example.namegenerator.dto.filter;

import lombok.Data;

@Data
public class SearchCriteria implements Filter {
    private final String type = "SEARCH";

    private String key;
    private String operation;
    private Object value;
}
