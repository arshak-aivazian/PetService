package com.example.userservice.config;

import com.example.userservice.stream.UserStatisticCommandHandler;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserConfiguration {
    @Bean
    public CommandDispatcher consumerCommandDispatcher(UserStatisticCommandHandler target,
                                                       SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {

        return sagaCommandDispatcherFactory.make("userCommandDispatcher", target.commandHandlerDefinitions());
    }
}
