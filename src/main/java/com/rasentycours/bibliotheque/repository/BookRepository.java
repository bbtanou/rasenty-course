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
    public Set<Book> showBooks() {
    	return books;
    }
    public Book findBookById(Long id) {
    	for(Book book: books) {
    		if(book.getId().equals(id)){
    			return book;
    		}
    	}
    	return null;
    }
    public boolean updateBook(Long id, Book updated) {
    	Book book = this.findBookById(id);
    	if(book!=null) {
    		book.setTitle(updated.getTitle());
    		book.setDescription(updated.getDescription());
    		book.setCategory(updated.getCategory());
    		book.setQuantity(updated.getQuantity());
    		books.add(book);
    		return true;
    	}
    	return false;
    }
}
