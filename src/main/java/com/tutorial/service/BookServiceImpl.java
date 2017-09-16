package com.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.dao.BookDAO;
import com.tutorial.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void persist(Book book) {
		bookDAO.persist(book);
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

}
