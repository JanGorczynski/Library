package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exceptions.BookCurrentlyRentedException;
import com.example.demo.exceptions.RentException;
import com.example.demo.exceptions.RentNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.dto.RentsDto;
import com.example.demo.repositories.BooksRepository;
import com.example.demo.repositories.RentsRepository;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.RentService;

@Controller
public class RentsControler {

    @Autowired
    RentsRepository rentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    RentService rentService;

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping(path = "/Rents")
    public ResponseEntity<Object> getRentsForUsername(@RequestParam(name = "username") String username) {
	try {

	    List<RentsDto> listDto = rentService.getRentsForUsername(username);
	    return new ResponseEntity<>(listDto, HttpStatus.OK);

	} catch (UserNotFoundException e) {
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @DeleteMapping(path = "/Rents/delete")
    public ResponseEntity<Object> deleteRent(@RequestParam(name = "id") Integer id) {
	try {
	    rentService.deleteRent(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	} catch (RentNotFoundException e) {
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
    }

    @PostMapping(path = "/Rents")
    public ResponseEntity<Object> addRent(@RequestParam(name = "user_id") Integer userId,
	    @RequestParam(name = "book_id") Integer bookId) {

	try {

	    RentsDto returnDto = rentService.rentBook(userId, bookId);
	    return new ResponseEntity<>(returnDto, HttpStatus.CREATED);

	} catch (BookCurrentlyRentedException e) {

	    return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

	} catch (RentException e) {

	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

	}
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PatchMapping(path = "/Rents/prolong")
    public ResponseEntity<Object> prolongRent(@RequestParam(name = "id") Integer id) {
	try {
	    RentsDto returnDto = rentService.prolongRent(id);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	} catch (RentNotFoundException e) {
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
    }
}
