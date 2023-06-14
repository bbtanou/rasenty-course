package com.rasentycours.bibliotheque.model.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private Long id;
    private String name;
    private String email;
    private String telephone;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            return true;
        }
        Person person = (Person) o;

        if (person.id.equals(this.id)) {
            return true;
        }

        return false;
        // return person.id.equals(this.id);
    }
}
