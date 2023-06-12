package com.rasentycours.bibliotheque.repository;

import com.rasentycours.bibliotheque.model.entities.SubscriptionType;
import java.util.HashSet;
import java.util.Set;

public class SubscriptionTypeRepository {

    private final Set<SubscriptionType> subscriptionTypes;

    public SubscriptionTypeRepository() {

        subscriptionTypes = new HashSet<>();
    }

    public void add(SubscriptionType subscriptionType) {

        subscriptionTypes.add(subscriptionType);
    }

    public Set<SubscriptionType> findAll() {

        return subscriptionTypes;
    }

    public void update(Long id, String name, Double amount) {

        SubscriptionType subscriptionType = null;
        for (SubscriptionType c : subscriptionTypes) {

            if (c.getId().equals(id)) {
                subscriptionType = c;
            }
        }

        if (subscriptionType != null) {

            subscriptionType.setName(name);
            subscriptionType.setAmount(amount);
            subscriptionTypes.add(subscriptionType);
        }
    }

    public void delete(Long id) {
        for (SubscriptionType subscriptionType : subscriptionTypes) {

            if (subscriptionType.getId().equals(id)) {

                subscriptionTypes.remove(subscriptionType);
                return;
            }
        }
    }

    public SubscriptionType findById(Long id) {

        for (SubscriptionType subscriptionType : subscriptionTypes) {
            if (subscriptionType.getId().equals(id)) {
                return subscriptionType;
            }
        }
        return null;
    }

}
