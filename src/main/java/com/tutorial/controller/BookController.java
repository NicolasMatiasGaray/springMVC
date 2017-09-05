package com.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.model.Book;
import com.tutorial.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public ModelAndView addBook() {
		Book book = new Book();
		book.setTitle("Insert a Book Title");
		book.setPrice(0d);
		
		return new ModelAndView("addBook","book", book); 
	}
	
	@RequestMapping(value="/saveBook", method=RequestMethod.POST)
	public ModelAndView saveBook(Book book) {
		bookService.persist(book);
		return new ModelAndView("listBooks","listBooks", bookService.getAll()); 
	}
}
