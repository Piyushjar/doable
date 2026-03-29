package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.subscription.PlanLimitsResponse;
import com.piyush.projects.doable.dto.subscription.UsageTodayResponse;
import com.piyush.projects.doable.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
