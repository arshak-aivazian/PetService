package com.example.userservice.mapper;

import com.example.userservice.dto.NewUserInfoRequest;
import com.example.userservice.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfo toUserInfo(NewUserInfoRequest source);
}
