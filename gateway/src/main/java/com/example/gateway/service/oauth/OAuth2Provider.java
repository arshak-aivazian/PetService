package com.example.gateway.service.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2Provider {

    public String getToken() {
        String token = ((JwtAuthenticationToken) SecurityContextHolder
                .getContext()
                .getAuthentication())
                .getToken()
                .getTokenValue();
        return "Bearer " + token;
    }
}
