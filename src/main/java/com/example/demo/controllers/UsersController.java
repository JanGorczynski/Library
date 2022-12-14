package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exceptions.UserNameTakenException;
import com.example.demo.model.Users;
import com.example.demo.model.dto.UsersDto;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UserService;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:5050")
    @PostMapping(path = "/user/add")
    public ResponseEntity<Object> createUser(@RequestParam(name = "username") String username,
	    @RequestParam(name = "password") String password) {
	try {
	    UsersDto input = new UsersDto();
	    input.setUsername(username);
	    input.setPassword(password);
	    UsersDto savedDto = userService.addUser(input);
	    return new ResponseEntity<Object>(savedDto, HttpStatus.CREATED);
	} catch (UserNameTakenException e) {

	    return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}

    }

    @CrossOrigin(origins = "http://localhost:5050")
    @GetMapping(path = "/user")
    public ResponseEntity<Object> getUser(@RequestParam(name = "username") String username) {
	Optional<Users> userOp = usersRepository.findByUsername(username);
	if (userOp.isEmpty()) {

	    return new ResponseEntity<Object>("123", HttpStatus.CONFLICT);
	} else {
	    Users user = userOp.get();
	    UsersDto userDto = new UsersDto(user);
	    return new ResponseEntity<Object>(userDto, HttpStatus.OK);
	}
    }
}
