package com.example.gateway.service.namegeneration;

import com.example.gateway.dto.NotificationMessage;
import com.example.gateway.dto.filter.Filter;
import com.example.gateway.service.notification.NotificationService;
import com.example.gateway.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NameGenerationServiceImpl implements NameGenerationService {

    private final UserService userService;
    private final NotificationService notificationService;

    @Override
    public void generate() {
        var userName = userService.getUserName();
        var message = new NotificationMessage(userName, null);
        notificationService.notificate(message);
    }

    @Override
    public void generateByFilter(Filter filter) {
        var userName = userService.getUserName();
        var message = new NotificationMessage(userName, filter);
        notificationService.notificate(message);
    }
}
