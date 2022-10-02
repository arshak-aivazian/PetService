package com.example.userservice.controller;

import com.example.userservice.dto.NewUserInfoRequest;
import com.example.userservice.entity.UserInfo;
import com.example.userservice.mapper.UserInfoMapper;
import com.example.userservice.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final UserInfoMapper userInfoMapper;

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userInfoService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable Long id) {
        return userInfoService.getUserInfo(id);
    }

    @GetMapping("/sync")
    public UserInfo sync() {
        return userInfoService.getCurrentUserInfo();
    }

    @PostMapping
    public void createUser(@RequestBody NewUserInfoRequest request) {
        var userInfo = userInfoMapper.toUserInfo(request);
        userInfoService.saveUserInfo(userInfo);
    }
}
