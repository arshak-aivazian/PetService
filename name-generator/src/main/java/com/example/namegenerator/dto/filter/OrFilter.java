package com.example.namegenerator.dto.filter;

import lombok.Data;

import java.util.List;

@Data
public class OrFilter implements Filter {
    private final String type = "OR";

    private List<Filter> value;
}
