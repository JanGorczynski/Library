package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BookCurrentlyRentedException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.exceptions.RentException;
import com.example.demo.exceptions.RentNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.model.Rents;
import com.example.demo.model.Users;
import com.example.demo.model.dto.RentsDto;
import com.example.demo.repositories.BooksRepository;
import com.example.demo.repositories.RentsRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class RentService {
    @Autowired
    RentsRepository rentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BooksRepository booksRepository;

    public RentsDto rentBook(Integer userId, Integer bookId) throws RentException {
	Optional<Users> userOp = usersRepository.findById(userId);
	Optional<Books> bookOp = booksRepository.findById(bookId);

	if (userOp.isEmpty()) {
	    throw new UserNotFoundException();
	}
	if (bookOp.isEmpty()) {
	    throw new BookNotFoundException();
	}

	Books book = bookOp.get();
	Users user = userOp.get();

	if (book.getCurrentlyRented() == true) {
	    throw new BookCurrentlyRentedException();
	}

	LocalDate dateOfRenting = LocalDate.now();
	LocalDate dateOfReturn = dateOfRenting.plusMonths(1);
	Rents rent = new Rents(book, user, dateOfRenting, dateOfReturn);

	user.getRents().add(rent);
	book.getRents().add(rent);
	book.setCurrentlyRented(true);
	booksRepository.save(book);
	Rents returnRent = rentsRepository.save(rent);

	return new RentsDto(returnRent);

    }

    public void deleteRent(Integer id) throws RentNotFoundException {
	Optional<Rents> rentOp = rentsRepository.findById(id);
	if (rentOp.isEmpty()) {
	    throw new RentNotFoundException();
	}

	Rents rent = rentOp.get();
	Books book = rent.getBook();

	book.setCurrentlyRented(false);
	rentsRepository.deleteById(id);

    }

    public RentsDto prolongRent(Integer id) throws RentNotFoundException {
	Optional<Rents> rentOp = rentsRepository.findById(id);
	if (rentOp.isEmpty()) {
	    throw new RentNotFoundException();
	}

	Rents rent = rentOp.get();
	LocalDate date = rent.getDateOfReturn().plusMonths(1);
	rent.setDateOfReturn(date);

	Rents returnRent = rentsRepository.save(rent);
	return new RentsDto(returnRent);

    }

    public List<RentsDto> getRentsForUsername(String username) throws UserNotFoundException {
	Optional<Users> userOp = usersRepository.findByUsername(username);

	if (userOp.isEmpty()) {
	    throw new UserNotFoundException();
	}

	List<Rents> list = rentsRepository.findByUserName(username);
	List<RentsDto> listDto = list.stream().map(rent -> new RentsDto(rent)).toList();

	return listDto;
    }

}
