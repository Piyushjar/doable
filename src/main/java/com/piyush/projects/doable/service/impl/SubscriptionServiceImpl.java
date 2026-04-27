package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.subscription.CheckoutRequest;
import com.piyush.projects.doable.dto.subscription.CheckoutResponse;
import com.piyush.projects.doable.dto.subscription.PortalResponse;
import com.piyush.projects.doable.dto.subscription.SubscriptionResponse;
import com.piyush.projects.doable.enums.SubscriptionStatus;
import com.piyush.projects.doable.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription() {
        return null;
    }

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {

    }

    @Override
    public void updateSubscription(String gatewaySubscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void cancelSubscription(String gatewaySubscriptionId) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }

    @Override
    public boolean canCreateNewProject() {
        return false;
    }
}
