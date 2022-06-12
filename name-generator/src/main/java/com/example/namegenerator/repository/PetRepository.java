package com.example.namegenerator.repository;

import com.example.namegenerator.entity.PetName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetName, Long> {
}
