package com.rasentycours.bibliotheque.service;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
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
        sc.nextLine();
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
        System.out.println("Livre ajouté avec succès!!!");
        sc.reset();
    }
    //
    public void showBooks() {
    	Set<Book> books = repository.showBooks();
    	for(Book book: books) {
    		System.out.println("ID: "+book.getId()+
    				"\n Description: "+book.getDescription()+
    				"\n Titre: "+book.getTitle()+
    				"\n Quantité: "+book.getQuantity()+
    				"\n ISBN: "+book.getIsbn()+
    				"\n Date de pub: "+book.getPublicationDate()+
    				"\n Statut: "+book.getStatus()
    				);
    	}
    }
    public void findBook() {
    	System.out.println("Donner l'id du livre à rechercher: ");
    	long id = sc.nextLong();
    	sc.nextLine();
    	Book book = repository.findBookById(id);
    	if(book!=null) {
    		System.out.println("---------------------");
    		System.out.println("ID: "+book.getId()+
    				"\n Description: "+book.getDescription()+
    				"\n Titre: "+book.getTitle()+
    				"\n Quantité: "+book.getQuantity()+
    				"\n ISBN: "+book.getIsbn()+
    				"\n Date de pub: "+book.getPublicationDate()+
    				"\n Statut: "+book.getStatus()
    				);
    		System.out.println("---------------------");
    	}else {
    		System.out.println("Livre non trouve");
    	}
    }
    public void updateBook() {
    	System.out.println("Donner le id du livre à modifier: ");
    	long id = sc.nextLong();
    	sc.nextLine();
    	System.out.println("Donner le nouveau nom du livre");
        String nom = sc.nextLine();
        System.out.println("Donner la nouvelle description du livre");
        String description = sc.nextLine();
        System.out.println("Donner le nombre d'exemplaire du livre");
        int quantite = sc.nextInt();
        sc.nextLine();
        Book book = Book.builder()
                .title(nom)
                .description(description)
                .quantity(quantite)
                .build(); 
        boolean res = repository.updateBook(id, book);
        if(res) {
        	System.out.println("Livre modifié avec succès!!!");
        }else {
        	System.out.println("Livre non modifié "); 
        }
    	
    }
}
