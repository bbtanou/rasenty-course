package com.rasentycours.bibliotheque.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Long id;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;

        return name.equals(category.getName());
    }

}
