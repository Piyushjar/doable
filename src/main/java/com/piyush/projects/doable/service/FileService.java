package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.project.FileContentResponse;

public interface FileService {
    FileService getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
