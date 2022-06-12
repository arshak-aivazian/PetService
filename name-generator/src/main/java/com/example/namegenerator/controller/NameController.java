package com.example.namegenerator.controller;

import com.example.namegenerator.dto.PetFilterDto;
import com.example.namegenerator.entity.PetName;
import com.example.namegenerator.service.NameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generate")
@CrossOrigin
@RequiredArgsConstructor
public class NameController {

    private final NameService nameService;

    @GetMapping
    public PetName generateRandomName() {
        return nameService.getRandomName();
    }

    @GetMapping(params = "filter")
    public List<PetName> generateName(@RequestParam PetFilterDto filter) {
        return nameService.findNameByFilter(filter);
    }
}
