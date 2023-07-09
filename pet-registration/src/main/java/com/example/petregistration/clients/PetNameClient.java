package com.example.petregistration.clients;

import com.example.petregistration.config.FeignConfig;
import com.example.petregistration.dto.PetNameDto;
import dto.PetNameRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "name-generator", url = "${GATEWAY_URL:http://localhost:8080/}name-generator", configuration = FeignConfig.class)
public interface PetNameClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/generate", consumes = "application/json")
    PetNameDto getRandomPetName(PetNameRequest request);

}
