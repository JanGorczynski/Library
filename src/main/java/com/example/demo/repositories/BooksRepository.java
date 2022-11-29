package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {
    public Optional<Books> findByTitle(String title);
}
