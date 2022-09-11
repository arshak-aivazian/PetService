package com.example.userservice.error;

public class UserInfoNotFoundException extends RuntimeException{
    public UserInfoNotFoundException(String message) {
        super(message);
    }
}