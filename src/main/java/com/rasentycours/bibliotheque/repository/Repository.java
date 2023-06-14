package com.rasentycours.bibliotheque.repository;

import java.util.Set;

public interface Repository<T> {
    void add(T object);

    T findById(Long id);

    Set<T> findAll();

    void deleteById(Long id);

    void update(Long id, T object);
}
