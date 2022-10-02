package com.example.gateway.feignclient;

import dto.PetNameRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "namegeneration", url = "${api.name-generation.url}", configuration = OAuthFeignConfig.class)
public interface NameGenerationClient {

    @PostMapping()
    String getPetName(PetNameRequest request);
}
