package com.example.gateway.service.namegeneration;

import com.example.gateway.dto.filter.Filter;

public interface NameGenerationService {
    void generate();
    void generateByFilter(Filter filter);
}
