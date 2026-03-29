package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.project.FileContentResponse;
import com.piyush.projects.doable.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileService getFileTree(Long projectId, Long userId) {
        return null;
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
