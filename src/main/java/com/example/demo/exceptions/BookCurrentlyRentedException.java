package com.example.demo.exceptions;

public class BookCurrentlyRentedException extends RentException {
    public BookCurrentlyRentedException() {
	super("Book Currently Rented");
    }
}
