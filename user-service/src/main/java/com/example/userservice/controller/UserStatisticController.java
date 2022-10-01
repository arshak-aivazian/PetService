package com.example.userservice.controller;

import com.example.userservice.mapper.StatisticMapper;
import com.example.userservice.service.UserInfoService;
import com.example.userservice.service.UserStatisticService;
import dto.UpdateUserStatisticMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statistics")
public class UserStatisticController {
    private final UserStatisticService statisticService;
    private final UserInfoService userInfoService;
    private final StatisticMapper mapper;

    @GetMapping
    public List<UpdateUserStatisticMessage> getUserStatistics(@RequestParam Long userId) {
        var userInfo = userInfoService.getUserInfo(userId);
        var statisitics = statisticService.getUserStatistics(userId);
        return statisitics.stream()
                .map(mapper::toEventMessage)
                .peek(it -> it.setUserName(userInfo.getUsername()))
                .collect(Collectors.toList());
    }
}
