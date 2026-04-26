package com.piyush.projects.doable.service.impl;

import com.piyush.projects.doable.dto.subscription.CheckoutRequest;
import com.piyush.projects.doable.dto.subscription.CheckoutResponse;
import com.piyush.projects.doable.dto.subscription.PortalResponse;
import com.piyush.projects.doable.dto.subscription.SubscriptionResponse;
import com.piyush.projects.doable.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

}
