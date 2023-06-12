package com.rasentycours.bibliotheque.service;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.rasentycours.bibliotheque.model.entities.SubscriptionType;
import com.rasentycours.bibliotheque.repository.SubscriptionTypeRepository;

public class SubscriptionTypeService {

    private final SubscriptionTypeRepository repository;
    private Scanner scanner = new Scanner(System.in);

    public SubscriptionTypeService() {

        repository = new SubscriptionTypeRepository();
    }

    public void addSubscriptionType() {

        System.out.println("Ajouter un nouvel type d'abonnement");
        System.out.print("Donner le nom de l'abonnement:");
        String nom = scanner.next();
        System.out.println("Donner le prix de l'abonnement");
        Double amount = scanner.nextDouble();

        long id = UUID.randomUUID().getLeastSignificantBits();
        SubscriptionType subscriptionType = SubscriptionType.builder()
                .name(nom)
                .amount(amount)
                .id(id)
                .build();

        repository.add(subscriptionType);
        scanner.reset();

    }

    public void showSubcriptionTypes() {

        System.out.println("Liste des Abonnements");
        List<SubscriptionType> subscriptionType = repository.findAll().stream().toList();
        if (subscriptionType.isEmpty()) {
            System.out.println("***********************************");
            System.out.println("La liste est vide");
            System.out.println("**********************************");
            return;
        }
        for (SubscriptionType category : subscriptionType) {

            System.out.println("ID : " + category.getId());
            System.out.println("Nom : " + category.getName());
            System.out.println("Description : " + category.getAmount());
            System.out.println("----------------------------------------------");
        }
    }

    public void updateSubcriptionType() {

        System.out.println("Donner l'identifiant du type d'abonnement à modifier : ");
        Long id = scanner.nextLong();

        System.out.println("Donner le nouveu nom de l'abonnement : ");
        String name = scanner.next();
        System.out.println("Donner le nouveau montant de l'abonnement : ");

        Double amount = scanner.nextDouble();
        repository.update(id, name, amount);
        scanner.reset();
    }

    public void deleteSubcriptionTypeById() {

        System.out.println("Suppression d'un type d'abonnement : ");
        System.out.println("Donner l'identifiant à supprimer : ");
        Long idSubscriptionType = scanner.nextLong();
        repository.delete(idSubscriptionType);
        System.out.println("Type d'abonnement supprimé avec succes");
        scanner.reset();

    }

    public void findSubscriptionTypeById() {

        System.out.println("Rechercher un type d'abonnement");
        System.out.println("Donner l'identifiant du type d'abonnement à rechercher :");
        Long id = scanner.nextLong();
        SubscriptionType subscriptionType = repository.findById(id);

        if (subscriptionType == null) {
            System.out.println("Impossible de trouver le type d'abonnement avec l'ID :" + id);
            return;
        }
        System.out.println("ID : +" + subscriptionType.getId());
        System.out.println("Nom : " + subscriptionType.getName());
        System.out.println("Montant : " + subscriptionType.getAmount());
        scanner.reset();
    }
}
