package com.example.namegenerator.service;

import com.example.namegenerator.dto.PetFilterDto;
import com.example.namegenerator.entity.PetName;
import com.example.namegenerator.error.PetNotFoundException;
import com.example.namegenerator.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {

    private final PetRepository petRepository;

    @Override
    public PetName getRandomName() {
        List<PetName> pets = petRepository.findAll();
        if (pets.isEmpty())
            throw new PetNotFoundException("pets names not found");

        Collections.shuffle(pets);
        return pets.get(0);
    }

    @Override
    public List<PetName> findNameByFilter(PetFilterDto filter) {
        List<PetName> petNames = petRepository.findAll();
        return petNames.stream().filter(pet -> isSuitableName(filter, pet))
                .collect(Collectors.toList());
    }

    private boolean isSuitableName(PetFilterDto filter, PetName pet) {
        boolean isSuitableSpecies = !hasText(filter.getSpecies()) || filter.getSpecies().equalsIgnoreCase(pet.getSpecies());
        boolean isSuitableGender = !hasText(filter.getGender()) || filter.getGender().equalsIgnoreCase(pet.getGender());

        return isSuitableGender && isSuitableSpecies;
    }
}
