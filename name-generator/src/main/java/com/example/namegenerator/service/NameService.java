package com.example.namegenerator.service;

import com.example.namegenerator.dto.filter.Filter;
import com.example.namegenerator.entity.PetName;

import java.util.List;

public interface NameService {
    PetName getRandomName();

    List<PetName> findNameByFilter(Filter filter);
}
