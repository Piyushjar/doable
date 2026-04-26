package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.project.ProjectRequest;
import com.piyush.projects.doable.dto.project.ProjectResponse;
import com.piyush.projects.doable.dto.project.ProjectSummaryResponse;
import com.piyush.projects.doable.entity.Project;
import com.piyush.projects.doable.entity.ProjectMember;
import com.piyush.projects.doable.entity.ProjectMemberId;
import com.piyush.projects.doable.entity.User;
import com.piyush.projects.doable.enums.ProjectRole;
import com.piyush.projects.doable.error.ResourceNotFoundException;
import com.piyush.projects.doable.mapper.ProjectMapper;
import com.piyush.projects.doable.repository.ProjectMemberRepository;
import com.piyush.projects.doable.repository.ProjectRepository;
import com.piyush.projects.doable.repository.UserRepository;
import com.piyush.projects.doable.security.AuthUtil;
import com.piyush.projects.doable.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        //User owner = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId.toString()));

        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .build();
        project = projectRepository.save(project);
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(project -> projectMapper.toProjectSummaryResponse(project))
//                .collect(Collectors.toList());
        Long userId = authUtil.getCurrentUserId();
        List<Project> projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
    return projectRepository
        .findAccessibleProjectById(projectId, userId)
        .orElseThrow(() -> new ResourceNotFoundException("Project",projectId.toString()));
    }
}
