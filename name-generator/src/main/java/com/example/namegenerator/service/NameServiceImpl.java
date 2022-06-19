package com.example.namegenerator.service;

import com.example.namegenerator.dto.filter.Filter;
import com.example.namegenerator.entity.PetName;
import com.example.namegenerator.error.PetNotFoundException;
import com.example.namegenerator.repository.PetRepository;
import com.example.namegenerator.utility.SpecificationCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
    public List<PetName> findNameByFilter(Filter filter) {
        Specification<PetName> specification = SpecificationCreator.create(filter);
        return petRepository.findAll(specification);
    }
}
