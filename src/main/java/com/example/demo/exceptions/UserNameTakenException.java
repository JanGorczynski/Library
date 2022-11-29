package com.example.demo.exceptions;

public class UserNameTakenException extends Exception {
    public UserNameTakenException() {
	super("User Name Taken");
    }
}
