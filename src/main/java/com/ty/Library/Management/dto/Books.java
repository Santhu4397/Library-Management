package com.ty.Library.Management.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Books {
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Id
	private int id;
	private String book_Name;
	private String author;
	private int stock;
	@JsonIgnore
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn,inverseJoinColumns = @JoinColumn)
	private List<User> user;
	

	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", book_Name=" + book_Name + ", author=" + author + ", stock=" + stock + ", user="
				+ user + "]";
	}
	
	

}
