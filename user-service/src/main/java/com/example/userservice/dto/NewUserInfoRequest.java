package com.example.userservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewUserInfoRequest {

    private String username;

    private String email;

    private String firstname;

    private String lastname;

    private LocalDate birthdate;
}
