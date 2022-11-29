package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Authors;
import com.example.demo.model.Books;
import com.example.demo.model.Rents;
import com.example.demo.model.Users;
import com.example.demo.repositories.AuthorsRepository;
import com.example.demo.repositories.BooksRepository;
import com.example.demo.repositories.RentsRepository;
import com.example.demo.repositories.UsersRepository;

class RepositoryTest extends VirtuallibraryprojectApplicationTests {

    @Autowired
    AuthorsRepository authorRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RentsRepository rentsRepository;

    @Test
    void bookRepositoryTest() {
	try {
	    Iterable<Books> books = booksRepository.findAll();
	    books.forEach(book -> {
		System.out.println(book);
	    });

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    fail();
	}
    }

    @Test
    void authorRepositoryTest() {
	try {

	    Iterable<Authors> authors = authorRepository.findAll();
	    authors.forEach(author -> {
		System.out.println(author);
	    });

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    fail();
	}
    }

    @Test
    void usersRepositoryTest() {

	try {
	    Iterable<Users> users = usersRepository.findAll();
	    users.forEach(user -> {
		System.out.println(user);
	    });

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    fail();
	}
    }

    @Test
    void rentsRepositoryTest() {
	try {
	    System.out.println("\n\n\n -----------RENTS-----------");

	    List<Rents> rents = rentsRepository.findByUserName("kemot");
	    System.out.println(rents.size());
	    rents.forEach(rent -> {
		System.out.println(rent);
	    });

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    fail();
	}
    }

}
