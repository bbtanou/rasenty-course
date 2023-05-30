package com.rasentycours.bibliotheque.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class SubscriptionType {
    private Long id;
    private String name;
    private Double amount;
}
