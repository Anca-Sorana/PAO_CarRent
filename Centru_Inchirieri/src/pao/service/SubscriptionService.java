package pao.service;


import pao.model.Subscription;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    void addSubscription(Subscription car);
    void removeSubscription(UUID id);
    void modifySubscription(UUID id, Subscription New);
    List<Subscription> allSubscription();
}
