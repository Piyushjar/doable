package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.member.InviteMemberRequest;
import com.piyush.projects.doable.dto.member.MemberResponse;
import com.piyush.projects.doable.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    void removeProjectMember(Long projectId, Long memberId, Long userId);

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);
}
