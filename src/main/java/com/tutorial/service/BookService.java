package com.tutorial.service;

import java.util.List;

import com.tutorial.model.Book;

public interface BookService {

	public void persist(Book book);
	
	public List<Book> getAll();
	
}
