package com.rasentycours.bibliotheque.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
public class Author extends Person {
    private String publishingHouse;
}
