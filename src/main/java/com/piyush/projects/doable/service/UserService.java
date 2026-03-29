package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
