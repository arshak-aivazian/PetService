package com.example.userservice.stream;

import com.example.command.NameGenerateCommand;
import com.example.command.UpdateUserStatisticsCommand;
import com.example.userservice.mapper.StatisticMapper;
import com.example.userservice.service.UserInfoService;
import com.example.userservice.service.UserStatisticService;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

@RequiredArgsConstructor
@Service
public class UserStatisticCommandHandler {
    private final UserStatisticService statisicService;
    private final UserInfoService userInfoService;
    private final StatisticMapper statisticMapper;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder
                .fromChannel("user-events")
                .onMessage(UpdateUserStatisticsCommand.class, this::updateStatistics)
                .build();
    }

    public Message updateStatistics(CommandMessage<UpdateUserStatisticsCommand> cm) {
        UpdateUserStatisticsCommand cmd = cm.getCommand();
        try {
            var userStatistic = statisticMapper.toStatistic(cm.getCommand());

            var user = userInfoService.getUserInfoByName(cm.getCommand().getUserName());
            userStatistic.setUserId(user.getId());

            statisicService.saveStatistic(userStatistic);
            return withSuccess(new CustomerCreditReserved());
        } catch (Exception e) {
            return withFailure(new RuntimeException());
        }
    }

}
