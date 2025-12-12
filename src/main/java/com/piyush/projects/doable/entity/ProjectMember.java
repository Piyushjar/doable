package com.piyush.projects.doable.entity;

import com.piyush.projects.doable.enums.ProjectRole;
import java.time.Instant;

public class ProjectMember {

    ProjectMemberId id;

    Project project;

    User user;

    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
