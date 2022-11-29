package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.UserNameTakenException;
import com.example.demo.model.Users;
import com.example.demo.model.dto.UsersDto;
import com.example.demo.repositories.UsersRepository;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public UsersDto addUser(UsersDto usersDto) throws UserNameTakenException {
	if (usersRepository.findByUsername(usersDto.getUsername()).isPresent()) {
	    throw new UserNameTakenException();
	} else {
	    Users user = new Users(usersDto);
	    Users temp = usersRepository.save(user);
	    return new UsersDto(temp);

	}
    }

}
