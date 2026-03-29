package com.piyush.projects.doable.repository;

import com.piyush.projects.doable.entity.ProjectMember;
import com.piyush.projects.doable.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

}
