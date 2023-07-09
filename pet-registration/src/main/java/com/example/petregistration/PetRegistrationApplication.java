package com.example.petregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PetRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetRegistrationApplication.class, args);
    }

}
