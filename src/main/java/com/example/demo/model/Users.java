package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.dto.UsersDto;

@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Rents> rents = new ArrayList<>();

    @Column(name = "user_password")
    private String password;

    public Users() {
	super();
    }

    public Users(UsersDto usersDto) {
	super();
	this.id = usersDto.getId();
	this.username = usersDto.getUsername();
	this.password = usersDto.getPassword();
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public List<Rents> getRents() {
	return rents;
    }

    public void setRents(List<Rents> rents) {
	this.rents = rents;
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
	Users other = (Users) obj;
	return Objects.equals(id, other.id) && Objects.equals(password, other.password)
		&& Objects.equals(username, other.username);
    }

    @Override
    public String toString() {
	return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

}
