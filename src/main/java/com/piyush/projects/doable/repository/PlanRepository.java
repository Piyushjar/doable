package com.piyush.projects.doable.repository;

import com.piyush.projects.doable.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
