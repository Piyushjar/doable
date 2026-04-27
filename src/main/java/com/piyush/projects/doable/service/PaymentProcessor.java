package com.piyush.projects.doable.service;

import com.piyush.projects.doable.dto.subscription.CheckoutRequest;
import com.piyush.projects.doable.dto.subscription.CheckoutResponse;
import com.piyush.projects.doable.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
