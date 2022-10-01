package com.example.namegenerator.service;

import com.example.namegenerator.entity.PetName;
import dto.PetNameRequest;

public interface NameService {
    PetName getRandomName(PetNameRequest request);
}
