package com.rasentycours.bibliotheque.model.entities;

import java.time.LocalDate;

import com.rasentycours.bibliotheque.model.enums.SubscriptionStatus;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Subscription {
    private Long id;
    private LocalDate subscriptionDate;
    private LocalDate expirationDate;
    private SubscriptionType subscriptionType;
    private Reader reader;
    private SubscriptionStatus status;

}
