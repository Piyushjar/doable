package com.piyush.projects.doable.mapper;

import com.piyush.projects.doable.dto.project.ProjectResponse;
import com.piyush.projects.doable.dto.project.ProjectSummaryResponse;
import com.piyush.projects.doable.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
