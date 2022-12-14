package com.example.demo.model.dto;

import com.example.demo.model.Books;

public class BooksDto {

    private Integer id;

    private String title;

    private String author;

    private Boolean currentlyRented;

    public BooksDto() {
	super();
    }

    public BooksDto(Books book) {
	id = book.getId();
	title = book.getTitle();
	author = book.getAuthor().getFullName();
	currentlyRented = book.getCurrentlyRented();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public Boolean getCurrentlyRented() {
	return currentlyRented;
    }

    public void setCurrentlyRented(Boolean currentlyRented) {
	this.currentlyRented = currentlyRented;
    }

}
