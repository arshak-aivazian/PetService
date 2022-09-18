package com.example.command;

import io.eventuate.tram.commands.common.Command;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserStatisticsCommand implements Command {
    private String userName;
    private LocalDateTime date;
    private String eventName;
    private String body;
}
