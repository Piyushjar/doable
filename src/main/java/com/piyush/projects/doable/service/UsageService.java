package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.subscription.PlanLimitsResponse;
import com.piyush.projects.doable.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
