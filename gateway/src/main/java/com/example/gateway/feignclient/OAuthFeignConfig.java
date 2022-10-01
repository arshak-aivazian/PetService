package com.example.gateway.feignclient;

import com.example.gateway.service.oauth.OAuth2Provider;
import feign.Logger;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class OAuthFeignConfig {

    private final OAuth2Provider oauth2Provider;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor barAuthZInterceptor() {
        return (requestTemplate) ->
                requestTemplate.header(
                        HttpHeaders.AUTHORIZATION, oauth2Provider.getToken());
    }
}
