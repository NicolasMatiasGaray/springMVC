package com.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@RequestMapping(value="/addNewBook", method=RequestMethod.GET)
	public String addBook() {
		return "addBook"; 
	}
	
}
