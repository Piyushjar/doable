package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.subscription.CheckoutRequest;
import com.piyush.projects.doable.dto.subscription.CheckoutResponse;
import com.piyush.projects.doable.dto.subscription.PortalResponse;

public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);
}
