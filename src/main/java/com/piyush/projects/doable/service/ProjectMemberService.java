package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.member.InviteMemberRequest;
import com.piyush.projects.doable.dto.member.MemberResponse;
import com.piyush.projects.doable.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);

    List<MemberResponse> getProjectMembers(Long projectId);
}
