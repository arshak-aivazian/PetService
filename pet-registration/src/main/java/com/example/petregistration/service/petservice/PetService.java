package com.example.petregistration.service.petservice;

import com.example.petregistration.dto.PetCreateEditDto;
import com.example.petregistration.dto.PetReadDto;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<PetReadDto> findAll();

    PetReadDto findById(Long id);

    PetReadDto create(PetCreateEditDto petDto);

    PetReadDto update(Long id, PetCreateEditDto petDto);

    boolean deletePet(Long id);

    Optional<byte[]> findAvatar(Long id);
}
