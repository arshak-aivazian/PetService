package com.example.namegenerator.steam;

import com.example.namegenerator.dto.InputNotificationMessage;
import com.example.namegenerator.dto.OutputNotificationMessage;
import com.example.namegenerator.entity.PetName;
import com.example.namegenerator.service.NameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class NameGenerationProccessor {
    private static final String EVENT_NAME = "NAME_GENERATION";

    private final NameService nameService;

    @Bean
    Function<InputNotificationMessage, OutputNotificationMessage> proccessor() {
        return input -> {
            PetName petName = null;

            if (input.getFilter() == null) {
                petName = nameService.getRandomName();
            } else {
                petName = nameService.findNameByFilter(input.getFilter())
                        .stream()
                        .findFirst()
                        .orElse(null);
            }

            var result = OutputNotificationMessage.builder()
                    .userName(input.getUserName())
                    .eventName(EVENT_NAME)
                    .date(LocalDateTime.now())
                    .body(petName.getName())
                    .build();

            log.info("name-generator generated message " + result);

            return result;
        };
    }
}
