package com.tutorial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String saveBook(@Valid Book book, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "addBook";
		} else {
			bookService.persist(book);
			model.put("listBooks", bookService.getAll());
			return "listBooks";
		}		 
	}
}
