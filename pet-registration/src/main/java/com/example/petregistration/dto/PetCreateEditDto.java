package com.example.petregistration.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PetCreateEditDto {
    private String species;
    private String breed;
    private String name;
    private String color;
    private String gender;
    private String description;
    private MultipartFile image;
}
