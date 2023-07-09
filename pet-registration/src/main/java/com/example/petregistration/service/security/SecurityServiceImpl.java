package com.example.petregistration.service.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements UserSecurityService {
    private static final String JWT_USERNAME_KEY = "preferred_username";

    @Override
    public String getUserName() {
        return ((JwtAuthenticationToken) SecurityContextHolder
                .getContext()
                .getAuthentication())
                .getTokenAttributes()
                .get(JWT_USERNAME_KEY)
                .toString();
    }
}
