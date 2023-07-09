package com.example.petregistration.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

public class FeignConfig {
    @Autowired
    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                var accessToken = getAccessToken();
                requestTemplate.header("Authorization", "Bearer " + accessToken.getTokenValue());
            }
        };
    }

    @Bean
    public OAuth2AuthorizedClientManager feignOAuth2AuthorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                                            OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        return new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
    }

    private OAuth2AccessToken getAccessToken() {
        var request = OAuth2AuthorizeRequest
                .withClientRegistrationId("external")
                .principal("principal-name")
                .build();
        return oAuth2AuthorizedClientManager.authorize(request).getAccessToken();
    }
}
