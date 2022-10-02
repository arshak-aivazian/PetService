package com.example.gateway.service.namegeneration;


import dto.filter.Filter;

public interface NameGenerationService {
    String generate();
    String generateByFilter(Filter filter);
}
