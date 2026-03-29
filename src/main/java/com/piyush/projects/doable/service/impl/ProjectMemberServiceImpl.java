package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.member.InviteMemberRequest;
import com.piyush.projects.doable.dto.member.MemberResponse;
import com.piyush.projects.doable.dto.member.UpdateMemberRoleRequest;
import com.piyush.projects.doable.entity.Project;
import com.piyush.projects.doable.entity.ProjectMember;
import com.piyush.projects.doable.entity.ProjectMemberId;
import com.piyush.projects.doable.entity.User;
import com.piyush.projects.doable.mapper.ProjectMemberMapper;
import com.piyush.projects.doable.repository.ProjectMemberRepository;
import com.piyush.projects.doable.repository.ProjectRepository;
import com.piyush.projects.doable.repository.UserRepository;
import com.piyush.projects.doable.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectMemberMapper projectMemberMapper;
    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
            projectMemberRepository.findByIdProjectId(projectId).stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList());
        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed to invite member");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User is already invited");
        }

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed to update member");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed to remove member");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User is not a member of this project");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    // INTERNAL FUNCTIONS
    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
    }

}
