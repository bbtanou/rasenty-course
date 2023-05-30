package com.rasentycours.bibliotheque.model.entities;

import java.time.LocalDate;

import com.rasentycours.bibliotheque.model.enums.LoanStatus;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Loan {
    private Long id;
    private LocalDate loanedAt;
    private LocalDate returnDate;
    private LocalDate returnedDate;
    private Person user;
    private Subscription subscription;
    private Book book;
    private LoanStatus status;

}
