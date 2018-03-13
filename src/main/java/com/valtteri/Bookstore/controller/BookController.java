package com.valtteri.Bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.valtteri.Bookstore.bean.Book;
import com.valtteri.Bookstore.repository.BookRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model){
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}
	
	@RequestMapping(value ="/addbook")
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		return "addbook";
	}
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String saveBook(Book book){
		repository.save(book);
		return "redirect:booklist";
	}
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteBooks(@PathVariable("id") Long id){
		repository.deleteById(id);
		return "redirect:../booklist";
	}
}