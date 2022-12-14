package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.model.dto.BooksDto;
import com.example.demo.repositories.BooksRepository;

@Service
public class BookService {

    @Autowired
    BooksRepository booksRepository;

    public List<BooksDto> getAvailableBooks() {
	List<BooksDto> dtoList = new ArrayList<>();
	List<Books> books = booksRepository.getAvailableBooks();
	for (Books book : books) {
	    dtoList.add(new BooksDto(book));
	}
	return dtoList;
    }
}
