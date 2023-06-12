package com.rasentycours.bibliotheque.service;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import com.rasentycours.bibliotheque.model.entities.Book;
import com.rasentycours.bibliotheque.model.enums.BookStatus;
import com.rasentycours.bibliotheque.repository.BookRepository;

public class BookService {

    private final BookRepository repository;
    private Scanner sc = new Scanner(System.in);

    public BookService() {

        repository = new BookRepository();

    }

    public void addBook() {

        System.out.println("Donner le nom du livre");
        String nom = sc.nextLine();
        System.out.println("Donner la description du livre");
        String description = sc.nextLine();
        System.out.println("Donner la quantite du livre");
        int quantite = sc.nextInt();
        Book book = Book.builder()
                .title(nom)
                .description(description)
                .quantity(quantite)
                .status(BookStatus.AVAILABLE)
                .publicationDate(LocalDate.now())
                .isbn(UUID.randomUUID().toString())
                .id(UUID.randomUUID().getLeastSignificantBits())
                .build();
        repository.add(book);
    }
}
