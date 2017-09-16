package com.tutorial.dao;

import java.util.List;

import com.tutorial.model.Book;

public interface BookDAO {

	public void persist(Book book);
	
	public List<Book> getAll();
}
