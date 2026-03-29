package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.auth.AuthResponse;
import com.piyush.projects.doable.dto.auth.LoginRequest;
import com.piyush.projects.doable.dto.auth.SignupRequest;
import com.piyush.projects.doable.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
