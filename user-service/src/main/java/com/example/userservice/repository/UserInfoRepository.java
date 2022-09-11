package com.example.userservice.repository;

import com.example.userservice.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findUserInfoByUsername(String userName);
}
