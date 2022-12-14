package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.dto.BooksDto;
import com.example.demo.services.BookService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @CrossOrigin(origins = "http://localhost:5050")
    @GetMapping(path = "/books")
    public ResponseEntity<Object> getAvailableBooks() {
	try {
	    List<BooksDto> dtos = bookService.getAvailableBooks();
	    return new ResponseEntity<>(dtos, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    }
}
