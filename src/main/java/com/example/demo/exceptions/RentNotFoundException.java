package com.example.demo.exceptions;

public class RentNotFoundException extends Exception {
    public RentNotFoundException() {
	super("Rent Not Found");
    }
}
