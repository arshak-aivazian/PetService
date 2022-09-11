package com.example.gateway.service.notification;

import com.example.gateway.dto.NotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NameNotificationService implements NotificationService {
    private final StreamBridge stream;

    private final String BINDING_NAME = "producer-out-0";

    @Override
    public void notificate(NotificationMessage message) {
        stream.send(BINDING_NAME, MessageBuilder.withPayload(message).build());
        log.info("published message: "+message);
    }
}
