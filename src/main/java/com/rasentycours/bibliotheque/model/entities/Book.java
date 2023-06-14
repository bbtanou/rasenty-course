package com.rasentycours.bibliotheque.model.entities;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

import com.rasentycours.bibliotheque.model.enums.BookStatus;

import lombok.ToString;

@Data
@ToString
@Builder
public class Book {
    private Long id;
    private String title;
    private LocalDate publicationDate;
    private Category category;
    private String isbn;
    private String description;
    private BookStatus status;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            return true;
        }
        Book book = (Book) o;
        if (book.getId().equals(this.id)) {
            return true;
        }

        return false;
    }
}
