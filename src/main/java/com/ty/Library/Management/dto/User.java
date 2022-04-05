package com.ty.Library.Management.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private int no_borrowed_book;
	private int no_returned_book;
	private LocalDate borrowed_Date;
	private LocalDate returned_Date;
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	@ManyToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Books> libraryDB;
	
	
	public LocalDate getBorrowed_Date() {
		return borrowed_Date;
	}
	public void setBorrowed_Date(LocalDate borrowed_Date) {
		this.borrowed_Date = borrowed_Date;
	}
	public LocalDate getReturned_Date() {
		return returned_Date;
	}
	public void setReturned_Date(LocalDate returned_Date) {
		this.returned_Date = returned_Date;
	}
	public List<Books> getLibraryDB() {
		return libraryDB;
	}
	public void setLibraryDB(List<Books> libraryDB) {
		this.libraryDB = libraryDB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo_borrowed_book() {
		return no_borrowed_book;
	}
	public void setNo_borrowed_book(int no_borrowed_book) {
		this.no_borrowed_book = no_borrowed_book;
	}
	public int getNo_returned_book() {
		return no_returned_book;
	}
	public void setNo_returned_book(int no_returned_book) {
		this.no_returned_book = no_returned_book;
	}
	

}
