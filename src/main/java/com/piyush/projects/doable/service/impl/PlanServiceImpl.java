package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.subscription.PlanResponse;
import com.piyush.projects.doable.repository.ProjectRepository;
import com.piyush.projects.doable.service.PlanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class PlanServiceImpl implements PlanService {


    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
