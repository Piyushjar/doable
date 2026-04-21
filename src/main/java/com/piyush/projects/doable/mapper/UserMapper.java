package com.piyush.projects.doable.mapper;

import com.piyush.projects.doable.dto.auth.SignupRequest;
import com.piyush.projects.doable.dto.auth.UserProfileResponse;
import com.piyush.projects.doable.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
