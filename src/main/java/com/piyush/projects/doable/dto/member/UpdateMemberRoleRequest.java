package com.piyush.projects.doable.dto.member;

import com.piyush.projects.doable.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull
        ProjectRole role
) {}
