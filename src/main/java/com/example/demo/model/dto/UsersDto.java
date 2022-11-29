package com.example.demo.model.dto;

import java.util.Objects;

import com.example.demo.model.Users;

public class UsersDto {

    private Integer id;
    private String username;
    private String password;

    public UsersDto() {
	super();
    }

    public UsersDto(Users user) {
	super();
	this.id = user.getId();
	this.username = user.getUsername();
	this.password = user.getPassword();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, password, username);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	UsersDto other = (UsersDto) obj;
	return Objects.equals(id, other.id) && Objects.equals(password, other.password)
		&& Objects.equals(username, other.username);
    }

}
