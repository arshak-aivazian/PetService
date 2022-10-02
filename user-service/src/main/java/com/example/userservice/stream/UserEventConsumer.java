package com.example.userservice.stream;

import com.example.userservice.mapper.StatisticMapper;
import com.example.userservice.service.UserInfoService;
import com.example.userservice.service.UserStatisticService;
import dto.UpdateUserStatisticMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class UserEventConsumer {
    private final UserStatisticService statisicService;
    private final UserInfoService userInfoService;
    private final StatisticMapper statisticMapper;

    @Bean
    public Consumer<UpdateUserStatisticMessage> eventConsumer() {
        return (msg) -> {
            log.info("recieved message - " + msg);

            var userStatistic = statisticMapper.toStatistic(msg);

            var user = userInfoService.getUserInfoByName(msg.getUserName());
            userStatistic.setUserId(user.getId());

            statisicService.saveStatistic(userStatistic);
        };
    }
}
