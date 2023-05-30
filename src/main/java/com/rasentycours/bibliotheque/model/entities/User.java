package com.rasentycours.bibliotheque.model.entities;

import com.rasentycours.bibliotheque.model.enums.UserStatus;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends Person {
    private String username;
    private String password;
    private UserStatus status;
}
