package com.example.namegenerator.dto.filter;

import lombok.Data;

import java.util.List;

@Data
public class AndFilter implements Filter {
    private final String type = "AND";

    private List<Filter> value;
}
