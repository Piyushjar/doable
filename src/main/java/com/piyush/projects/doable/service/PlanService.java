package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
