package com.valtteri.Bookstore.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtteri.Bookstore.bean.Book;
import com.valtteri.Bookstore.repository.BookRepository;

@RestController
public class BookRestController {
	@Autowired
	@Id
	
	private BookRepository repository;
	
		@RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) repository.findAll();
	    } 
			
		@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
		public Optional<Book> findById(@PathVariable(value = "id") Long id)	{
			return repository.findById(id);
		}
	
}
