package com.piyush.projects.doable.dto.project;

import java.time.Instant;

public record FileNode(
        String pat,
        Instant modifiedAt,
        Long size,
        String type
) {}
