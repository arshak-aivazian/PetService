package com.example.userservice.mapper;

import com.example.userservice.dto.EventMessage;
import com.example.userservice.entity.UserStatistic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatisticMapper {

    @Mapping(target="eventName", source="event")
    @Mapping(target="body", source="value")
    EventMessage toEventMessage(UserStatistic source);

    @Mapping(target="event", source="eventName")
    @Mapping(target="value", source="body")
    UserStatistic toStatistic(EventMessage source);
}
