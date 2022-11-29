package com.example.demo.exceptions;

public class UserNotFoundException extends RentException {
    public UserNotFoundException() {
	super("User Not Found");
    }
}
