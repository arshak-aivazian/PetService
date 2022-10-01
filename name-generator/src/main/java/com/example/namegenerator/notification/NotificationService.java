package com.example.namegenerator.notification;


import dto.UpdateUserStatisticMessage;

public interface NotificationService {
    void notificate(UpdateUserStatisticMessage message);
}
