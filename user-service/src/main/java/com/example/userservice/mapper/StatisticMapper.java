package com.example.userservice.mapper;

import com.example.userservice.entity.UserStatistic;
import dto.UpdateUserStatisticMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatisticMapper {

    @Mapping(target="eventName", source="event")
    @Mapping(target="body", source="value")
    UpdateUserStatisticMessage toEventMessage(UserStatistic source);

    @Mapping(target="event", source="eventName")
    @Mapping(target="value", source="body")
    UserStatistic toStatistic(UpdateUserStatisticMessage source);
}
