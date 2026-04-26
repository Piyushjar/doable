package com.piyush.projects.doable.repository;

import com.piyush.projects.doable.entity.ProjectMember;
import com.piyush.projects.doable.entity.ProjectMemberId;
import com.piyush.projects.doable.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query("""
                SELECT pm.projectRole FROM ProjectMember pm
                WHERE pm.id.projectId = :projectId
                AND pm.id.userId = :userId
            """)
    Optional<ProjectRole> findRoleByProjectIdAndUserId(Long projectId, Long userId);
}
