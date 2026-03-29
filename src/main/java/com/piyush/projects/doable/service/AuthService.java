package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.auth.AuthResponse;
import com.piyush.projects.doable.dto.auth.LoginRequest;
import com.piyush.projects.doable.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
