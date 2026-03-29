package com.piyush.projects.doable.dto.member;

import com.piyush.projects.doable.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        String avatarUrl,
        ProjectRole projectRole,
        Instant invitedAt
) {}
