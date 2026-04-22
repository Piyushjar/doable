package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.project.ProjectRequest;
import com.piyush.projects.doable.dto.project.ProjectResponse;
import com.piyush.projects.doable.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
