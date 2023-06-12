package com.rasentycours.bibliotheque.repository;

import java.util.HashSet;
import java.util.Set;

import com.rasentycours.bibliotheque.model.entities.Book;

public class BookRepository {
    private final Set<Book> books;// création dune liste

    public BookRepository() {

        books = new HashSet<>();// initialisation de la liste
    }

    public void add(Book book) {

        books.add(book);// insertion
    }
}
