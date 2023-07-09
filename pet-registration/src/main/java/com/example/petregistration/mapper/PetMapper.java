package com.example.petregistration.mapper;

import com.example.petregistration.dto.PetCreateEditDto;
import com.example.petregistration.dto.PetReadDto;
import com.example.petregistration.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static java.util.function.Predicate.not;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(target = "image", source = "image", qualifiedByName = "getFileName")
    Pet toPet(PetCreateEditDto source);

    PetReadDto toPetReadDto(Pet source);

    @Named("getFileName")
    default String getFileName(MultipartFile image) {
        return Optional.ofNullable(image)
                .filter(not(MultipartFile::isEmpty))
                .map(MultipartFile::getOriginalFilename)
                .orElse(null);
    }

    default void copy(Pet entity, PetCreateEditDto dto) {
        entity.setSpecies(dto.getSpecies());
        entity.setBreed(dto.getBreed());
        entity.setColor(entity.getColor());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setImage(entity.getImage() == null ? null : getFileName(dto.getImage()));
    }
}
