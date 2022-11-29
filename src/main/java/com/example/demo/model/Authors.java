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

@Entity
@Table(name = "AUTHORS")
public class Authors {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "author")
    private List<Books> books = new ArrayList<>();

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public List<Books> getBooks() {
	return books;
    }

    public void setBooks(List<Books> books) {
	this.books = books;
    }

    @Override
    public int hashCode() {
	return Objects.hash(fullName, id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Authors other = (Authors) obj;
	return Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	return "Authors [id=" + id + ", fullName=" + fullName + "]";
    }

}
