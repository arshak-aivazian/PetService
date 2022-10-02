package com.example.gateway.service.namegeneration;

import com.example.gateway.feignclient.NameGenerationClient;
import com.example.gateway.service.userservice.UserService;
import dto.PetNameRequest;
import dto.filter.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NameGenerationServiceImpl implements NameGenerationService {

    private final UserService userService;
    private final NameGenerationClient client;

    @Override
    public String generate() {
        var request = new PetNameRequest();
        request.setUsername(userService.getUserName());

        return client.getPetName(request);
    }

    @Override
    public String generateByFilter(Filter filter) {
        var request = new PetNameRequest();
        request.setFilter(filter);
        request.setUsername(userService.getUserName());

        return client.getPetName(request);
    }
}
