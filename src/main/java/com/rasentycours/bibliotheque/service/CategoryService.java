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
        System.out.println("Ajout d'une nouvelle categorie");

        System.out.print("Donner le nom : ");
        String nom = scanner.next();
        System.out.print("Donner la description : ");
        String description = scanner.next();

        Long id = UUID.randomUUID().getMostSignificantBits();

        Category category = Category.builder()
                .name(nom)
                .description(description)
                .id(id)
                .build();

        repository.add(category);
        scanner.reset();
    }

    public void showCategories() {
        System.out.println("List des categories...");

        List<Category> categories = repository.findAll().stream().toList();
        if (categories.isEmpty()) {
            System.out.println("*****************************");
            System.out.println("Vous n'avez aucune categorie");
            System.out.println("*****************************");

            return;
        }

        for (Category category : categories) {

            System.out.println("ID : " + category.getId());
            System.out.println("Nom : " + category.getName());
            System.out.println("Description: " + category.getDescription());

            System.out.println("------------------------------------------------");
        }
    }

    public void updateCategory() {
        System.out.print("Donner l'identifiant a modifier : ");
        Long id = scanner.nextLong();

        System.out.print("Donner le nouveau nom de la categorie : ");
        String name = scanner.next();
        System.out.print("Donner la nouvelle description : ");
        String description = scanner.next();

        repository.update(id, name, description);
        scanner.reset();
    }

    public void deleteCategoryById() {
        System.out.println("Suppression d'une category");

        System.out.println("Donner l'identifiant de la categorie a supprimer : ");
        Long idCategory = scanner.nextLong();

        repository.delete(idCategory);
        System.out.println("Categorie supprimee avec succes");
        scanner.reset();
    }

    public void findCategoryById() {
        System.out.println("Rechercher une categorie");
        System.out.println("Donner l'identifiant de la categorie a rechercher : ");
        Long id = scanner.nextLong();

        Category category = repository.findById(id);

        if (category == null) {
            System.out.println("Impossible de trouver la category avec id : " + id);
            return;
        }

        System.out.println("ID : " + category.getId());
        System.out.println("Nom : " + category.getName());
        System.out.println("Description : " + category.getDescription());

        scanner.reset();
    }
}
