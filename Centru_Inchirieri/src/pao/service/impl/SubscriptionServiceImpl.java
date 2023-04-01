package pao.service.impl;

import pao.model.Subscription;
import pao.service.SubscriptionService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SubscriptionServiceImpl implements SubscriptionService {
    private static List<Subscription> subscriptionList = new ArrayList<>();
    @Override
    public void addSubscription(Subscription subscription) {
        subscriptionList.add(subscription);
    }

    @Override
    public void removeSubscription(UUID id) {
        subscriptionList = subscriptionList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifySubscription(UUID id, Subscription New) {
        removeSubscription(id);
        addSubscription(New);
    }

    @Override
    public List<Subscription> allSubscription() {
        return subscriptionList;
    }
}
