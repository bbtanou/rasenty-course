package com.rasentycours.bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.rasentycours.bibliotheque.model.entities.Category;

public class App {
    private static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            menu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addCategory();
                case 8 -> showCategories();
            }
        } while (choice <= 0 || choice <= 10);
    }

    public static void menu() {
        System.out.println("Bienvenue dans votre bibliotheque");

        System.out.println("1   - Ajouter une category");
        System.out.println("2   - Ajouter un livre");
        System.out.println("3   - Ajouter un auteur");
        System.out.println("4   - Ajouter un Lecteur");
        System.out.println("5   - Ajouter un type d'abonnement");
        System.out.println("6   - Ajouter un emprunt");
        System.out.println("7   - Afficher les livres");
        System.out.println("8   - Afficher les Categories");
        System.out.println("9   - Afficher les Lecteurs");
        System.out.println("10  - Afficher les Auteurs");
        System.out.print("Faites un choix : ");
    }

    public static void addCategory() {
        System.out.println("_______________________________");
        String choice = "N";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Donnez le nom de la categorie : ");
            String nom = scanner.next();
            System.out.println("Donner la description : ");
            String description = scanner.next();

            Category category = Category.builder()
                    .id(UUID.randomUUID().getMostSignificantBits())
                    .name(nom)
                    .description(description)
                    .build();

            categories.add(category);
            System.out.println("AJouter une nouvelle categorie Y/N : ");
            Scanner scanner2 = new Scanner(System.in);
            choice = scanner2.next();

        } while (choice.equals("Y") | choice.equals("y"));

    }

    public static void showCategories() {
        System.out.println("List des categories");
        categories.forEach(category -> {
            System.out.println("ID : " + category.getId());
            System.out.println("Nom : " + category.getName());
            System.out.println("Description : " + category.getDescription());
            System.out.println("_____________________________________________");
        });

    }
}