package com.rasentycours.bibliotheque.repository;

import java.util.HashSet;
import java.util.Set;

import com.rasentycours.bibliotheque.model.entities.Reader;

public class ReaderRepository implements Repository<Reader> {
    private Set<Reader> readers;

    public ReaderRepository() {
        readers = new HashSet<>();
    }

    @Override
    public void add(Reader object) {
        readers.add(object);
    }

    @Override
    public Reader findById(Long id) {
        for (Reader reader : readers) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
        // return readers.stream()
        // .filter(r -> r.getId().equals(id))
        // .findFirst().orElse(null);
    }

    @Override
    public Set<Reader> findAll() {
        return readers;
    }

    @Override
    public void deleteById(Long id) {
        Reader reader = findById(id);
        readers.remove(reader);
    }

    @Override
    public void update(Long id, Reader object) {
        Reader exinstingReader = findById(id);
        exinstingReader.setEmail(object.getEmail());
        exinstingReader.setName(object.getName());
        exinstingReader.setTelephone(object.getTelephone());

        readers.add(exinstingReader);
    }

}
