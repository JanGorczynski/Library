package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.dto.RentsDto;

@Entity
public class Rents {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private Users user;

    @Column(name = "date_of_renting")
    private LocalDate dateOfRenting;

    @Column(name = "date_of_return")
    private LocalDate dateOfReturn;

    public Rents() {
	super();
    }

    public Rents(Books book, Users user, LocalDate dateOfRenting, LocalDate dateOfReturn) {
	super();
	this.book = book;
	this.user = user;
	this.dateOfRenting = dateOfRenting;
	this.dateOfReturn = dateOfReturn;
    }

    public Rents(Books book, Users user, RentsDto rentsDto) {
	super();
	this.book = book;
	this.user = user;
	this.dateOfRenting = rentsDto.getDateOfRenting();
	this.dateOfReturn = rentsDto.getDateOfReturn();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Books getBook() {
	return book;
    }

    public void setBook(Books book) {
	this.book = book;
    }

    public Users getUser() {
	return user;
    }

    public void setUser(Users user) {
	this.user = user;
    }

    public LocalDate getDateOfRenting() {
	return dateOfRenting;
    }

    public void setDateOfRenting(LocalDate dateOfRenting) {
	this.dateOfRenting = dateOfRenting;
    }

    public LocalDate getDateOfReturn() {
	return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
	this.dateOfReturn = dateOfReturn;
    }

    @Override
    public int hashCode() {
	return Objects.hash(dateOfRenting, dateOfReturn, id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Rents other = (Rents) obj;
	return Objects.equals(dateOfRenting, other.dateOfRenting) && Objects.equals(dateOfReturn, other.dateOfReturn)
		&& Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	return "Rents [id=" + id + ", dateOfRenting=" + dateOfRenting + ", dateOfReturn=" + dateOfReturn + "]";
    }

}
