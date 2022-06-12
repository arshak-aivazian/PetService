package com.example.namegenerator.service;

import com.example.namegenerator.dto.PetFilterDto;
import com.example.namegenerator.entity.PetName;

import java.util.List;

public interface NameService {
    PetName getRandomName();

    List<PetName> findNameByFilter(PetFilterDto filter);
}
