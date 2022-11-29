package com.example.demo.model.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.example.demo.model.Rents;

public class RentsDto {

    private Integer id;

    private String bookTitle;

    private String username;

    private String author;

    private LocalDate dateOfRenting;

    private LocalDate dateOfReturn;

    private boolean isOverdue;

    public RentsDto() {
	super();
    }

    public RentsDto(Rents rent) {
	super();
	this.id = rent.getId();
	this.bookTitle = rent.getBook().getTitle();
	this.username = rent.getUser().getUsername();
	this.author = rent.getBook().getAuthor().getFullName();
	this.dateOfRenting = rent.getDateOfRenting();
	this.dateOfReturn = rent.getDateOfReturn();
	this.isOverdue = LocalDate.now().isAfter(dateOfReturn);
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getBookTitle() {
	return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
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

    public boolean isOverdue() {
	return isOverdue;
    }

    public void setOverdue(boolean isOverdue) {
	this.isOverdue = isOverdue;
    }

    @Override
    public String toString() {
	return "RentsDto [id=" + id + ", bookTitle=" + bookTitle + ", username=" + username + ", author=" + author
		+ ", dateOfRenting=" + dateOfRenting + ", dateOfReturn=" + dateOfReturn + "]";
    }

    @Override
    public int hashCode() {
	return Objects.hash(author, bookTitle, dateOfRenting, dateOfReturn, id, isOverdue, username);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	RentsDto other = (RentsDto) obj;
	return Objects.equals(author, other.author) && Objects.equals(bookTitle, other.bookTitle)
		&& Objects.equals(dateOfRenting, other.dateOfRenting)
		&& Objects.equals(dateOfReturn, other.dateOfReturn) && Objects.equals(id, other.id)
		&& isOverdue == other.isOverdue && Objects.equals(username, other.username);
    }

}
