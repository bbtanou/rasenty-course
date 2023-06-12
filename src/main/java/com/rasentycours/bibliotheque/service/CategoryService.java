package com.rasentycours.bibliotheque.service;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.rasentycours.bibliotheque.model.entities.Category;
import com.rasentycours.bibliotheque.repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository repository;
    private Scanner scanner = new Scanner(System.in);

    public CategoryService() {

        repository = new CategoryRepository();
    }

    public void addCategory() {

        System.out.println("Ajouter une nouvelle catégorie");
        System.out.print("Donner le nom :");
        String nom = scanner.next();
        String description = scanner.next();

        long id = UUID.randomUUID().getLeastSignificantBits();
        Category category = Category.builder()
                .name(nom)
                .description(description)
                .id(id)
                .build();

        repository.add(category);
        scanner.reset();

    }

    public void showCategories() {

        System.out.println("Liste des catégories");
        List<Category> categories = repository.findAll().stream().toList();
        if (categories.isEmpty()) {
            System.out.println("***********************************");
            System.out.println("La liste est vide");
            System.out.println("**********************************");
            return;
        }
        for (Category category : categories) {

            System.out.println("ID : " + category.getId());
            System.out.println("Nom : " + category.getName());
            System.out.println("Description : " + category.getDescription());
            System.out.println("----------------------------------------------");
        }
    }

    public void updateCategory() {

        System.out.println("Donner l'identifiant de la catégorie à modifier : ");
        Long id = scanner.nextLong();

        System.out.println("Donner le nouveu nom de la catégorie : ");
        String name = scanner.next();
        System.out.println("Donner la nouvelle Description : ");

        String description = scanner.next();
        repository.update(id, name, description);
        scanner.reset();
    }

    public void deleteCategorieById() {

        System.out.println("Suppression d'une Catégorie : ");
        System.out.println("Donner l'identifiant à supprimer : ");
        Long idCategory = scanner.nextLong();
        repository.delete(idCategory);
        System.out.println("Categorie supprimée avec succes");
        scanner.reset();

    }

    public void findCategoryById() {

        System.out.println("Rechercher une catégory");
        System.out.println("Donner l'identifiant de la catégori à rechercher :");
        Long id = scanner.nextLong();
        Category category = repository.findById(id);

        if (category == null) {
            System.out.println("Impossible de trouver la catégorie avec l'ID :" + id);
            return;
        }
        System.out.println("ID : +" + category.getId());
        System.out.println("Nom : " + category.getName());
        System.out.println("Description : " + category.getDescription());
        scanner.reset();
    }
}