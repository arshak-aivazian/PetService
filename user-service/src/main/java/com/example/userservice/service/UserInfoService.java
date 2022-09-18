package com.example.userservice.service;

import com.example.userservice.entity.UserInfo;
import com.example.userservice.error.UserInfoNotFoundException;
import com.example.userservice.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final SecurityService securityService;

    @Transactional
    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public UserInfo getUserInfo(Long id) {
        return userInfoRepository.findById(id)
                .orElseThrow(() -> new UserInfoNotFoundException("user with id - " + id + " not found"));
    }

    public UserInfo getUserInfoByName(String userName) {
        var userInfo = userInfoRepository.findUserInfoByUsername(userName);

        if (userInfo == null) {
            throw new UserInfoNotFoundException("user with name - " + userName + " not found");
        }

        return userInfo;
    }

    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo getCurrentUserInfo() {
        var userName = securityService.getUserName();
        return getUserInfoByName(userName);
    }
}
