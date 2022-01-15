package com.bigplex.bigplex.subscription.service;

import com.bigplex.bigplex.subscription.dto.SubscriptionDto;
import com.bigplex.bigplex.subscription.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription addNew(SubscriptionDto subscriptionDto);
    Subscription subscribe(int userId, int packId);
    Subscription getSubscription(int subId);
    List<Subscription> getUserAll(int userId);
    List<Subscription> getPackAll(int packId);

}
