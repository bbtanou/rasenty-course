package com.rasentycours.bibliotheque.repository;

import java.util.HashSet;
import java.util.Set;

import com.rasentycours.bibliotheque.model.entities.Category;

public class CategoryRepository {
    private final Set<Category> categories;

    public CategoryRepository() {
        categories = new HashSet<>();
    }

    public void add(Category category) {
        categories.add(category);
    }

    public Set<Category> findAll() {
        return categories;
    }

    public void update(Long id, String name, String description) {
        Category category = null;

        for (Category c : categories) {
            if (c.getId().equals(id)) {
                category = c;
            }
        }

        if (category != null) {
            category.setName(name);
            category.setDescription(description);

            categories.add(category);
        }

    }

    public void delete(Long id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                categories.remove(category);
                return;
            }
        }
    }

    public Category findById(Long id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {

                return category;
            }
        }

        return null;
    }

}
