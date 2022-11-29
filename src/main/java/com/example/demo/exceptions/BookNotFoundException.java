package com.example.demo.exceptions;

public class BookNotFoundException extends RentException {
    public BookNotFoundException() {
	super("Book Not Found");
    }
}
