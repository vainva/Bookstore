package com.valtteri.Bookstore.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 
 private Long id;
 
 private String title;
 private String author;
 private String year;
 private String isbn;
 
 public Book() {}
	 
	 public Book(String title, String author, String year, String isbn) {
		 super();
		 this.title = title;
		 this.author = author;
		 this.year = year;
		 this.isbn = isbn;
	 }
	 
	 public Long getId(){
		 return id;
	 }
	 public void setId(Long id){
		 this.id = id;
	 }
	 
	 public String getTitle(){
		 return title;
	 }
	 public void setTitle(String title){
		 this.title = title;
	 }
	 public String getAuthor(){
		 return author;
	 }
	 public void setAuthor(String author){
		 this.author = author;
	 }
	 public String getYear(){
		 return year;
	 }
	 public void setYear(String year){
		 this.year = year;
	 }
	 public String getIsbn(){
		 return isbn;
	 }
	 public void setIsbn(String isbn){
		 this.isbn = isbn;
	 }
	 
	 @Override
	 public String toString(){
		 return "Book [" + "id=" + id +
				 ", title=" + title +
				 ", author=" + author +
				 ", year=" + year +
				 ", isbn=" + isbn +"]";
	 }
	 
 }
