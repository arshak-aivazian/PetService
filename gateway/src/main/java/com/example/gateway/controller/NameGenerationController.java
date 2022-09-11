package com.example.gateway.controller;

import com.example.gateway.dto.filter.Filter;
import com.example.gateway.service.namegeneration.NameGenerationService;
import com.example.gateway.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
@RequiredArgsConstructor
public class NameGenerationController {

    private final NameGenerationService service;
    private final UserService userService;

    @GetMapping
    public void generateRandomName() {
        service.generate();
    }

    @PostMapping
    public void generateName(@RequestBody Filter filter) {
        service.generateByFilter(filter);
    }
}
