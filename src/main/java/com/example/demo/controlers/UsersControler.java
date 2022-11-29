package com.example.demo.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exceptions.UserNameTakenException;
import com.example.demo.model.dto.UsersDto;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UserService;

@Controller
public class UsersControler {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserService userService;

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody UsersDto usersDto) {
	try {
	    UsersDto savedDto = userService.addUser(usersDto);
	    return new ResponseEntity<Object>(savedDto, HttpStatus.CREATED);
	} catch (UserNameTakenException e) {

	    return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}

    }
}
