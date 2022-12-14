package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {

    @Query(value = "select * from BOOKS where currently_rented=0", nativeQuery = true)
    public List<Books> getAvailableBooks();
}
