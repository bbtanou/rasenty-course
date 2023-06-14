package com.rasentycours.bibliotheque.service;

import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import com.rasentycours.bibliotheque.model.entities.Reader;
import com.rasentycours.bibliotheque.repository.ReaderRepository;
import com.rasentycours.bibliotheque.repository.Repository;

public class ReaderService {
    private Repository<Reader> repository;
    private Scanner sc = new Scanner(System.in);
    // private ReaderRepository repository;

    public ReaderService() {
        repository = new ReaderRepository();

    }

    public void addReader() {
        System.out.println("---------------------------");
        System.out.print("Donner le nom : ");
        String nom = sc.nextLine();
        System.out.print("Donner l'adresse email : ");
        String email = sc.nextLine();
        System.out.print("Donner le numero de telephone : ");
        String phone = sc.nextLine();

        Reader reader = new Reader();
        reader.setEmail(email);
        reader.setName(nom);
        reader.setTelephone(phone);
        reader.setId(UUID.randomUUID().getMostSignificantBits());

        repository.add(reader);
    }

    public void showReaders() {
        System.out.println("Liste des lecteurs....");
        Set<Reader> readers = repository.findAll();

        // for(Reader reader : readers){
        // System.out.println("ID : " + reader.getId());
        // System.out.println("Nom : " + reader.getName());
        // System.out.println("Email : " + reader.getEmail());
        // System.out.println("Telephone : " + reader.getTelephone());
        // }

        readers.forEach(reader -> {
            System.out.println("ID : " + reader.getId());
            System.out.println("Nom : " + reader.getName());
            System.out.println("Email : " + reader.getEmail());
            System.out.println("Telephone : " + reader.getTelephone());
        });
    }

}
