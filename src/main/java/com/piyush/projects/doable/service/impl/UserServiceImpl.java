package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.auth.UserProfileResponse;
import com.piyush.projects.doable.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
