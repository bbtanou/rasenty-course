package com.rasentycours.bibliotheque.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class Person {
    private Long id;
    private String name;
    private String email;
    private String telephone;
}
