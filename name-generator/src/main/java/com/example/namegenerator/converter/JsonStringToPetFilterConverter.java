package com.example.namegenerator.converter;

import com.example.namegenerator.dto.PetFilterDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class JsonStringToPetFilterConverter implements Converter<String, PetFilterDto> {

    private final ObjectMapper jsonMapper = new ObjectMapper();

    @SneakyThrows
    public PetFilterDto convert(String source) {
        return jsonMapper.readValue(source, PetFilterDto.class);
    }
}
