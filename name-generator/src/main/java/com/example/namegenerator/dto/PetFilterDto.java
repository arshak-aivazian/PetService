package com.example.namegenerator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PetFilterDto {
    @NotNull
    private String species;

    @NotNull
    private String gender;
}
