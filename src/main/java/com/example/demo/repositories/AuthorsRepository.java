package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Authors;

@Repository
public interface AuthorsRepository extends CrudRepository<Authors, Integer> {

}
