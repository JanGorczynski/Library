package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Books {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Authors author;

    @Column(name = "currently_rented")
    private Boolean currentlyRented;

    @OneToMany(mappedBy = "book")
    private List<Rents> rents = new ArrayList<>();

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Authors getAuthor() {
	return author;
    }

    public void setAuthor(Authors author) {
	this.author = author;
    }

    public List<Rents> getRents() {
	return rents;
    }

    public void setRents(List<Rents> rents) {
	this.rents = rents;
    }

    public Boolean getCurrentlyRented() {
	return currentlyRented;
    }

    public void setCurrentlyRented(Boolean currentlyRented) {
	this.currentlyRented = currentlyRented;
    }

    @Override
    public int hashCode() {
	return Objects.hash(author, id, title);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Books other = (Books) obj;
	return Objects.equals(author, other.author) && Objects.equals(id, other.id)
		&& Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
	return "Books [id=" + id + ", title=" + title + ", currentlyRented=" + currentlyRented + "]";
    }

}
