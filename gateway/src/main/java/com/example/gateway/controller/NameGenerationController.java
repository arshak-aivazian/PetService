package com.example.gateway.controller;

import com.example.gateway.service.namegeneration.NameGenerationService;
import dto.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
@RequiredArgsConstructor
public class NameGenerationController {

    private final NameGenerationService service;

    @GetMapping
    public String generateRandomName() {
        return service.generate();
    }

    @PostMapping
    public String generateName(@RequestBody Filter filter) {
        return service.generateByFilter(filter);
    }
}
