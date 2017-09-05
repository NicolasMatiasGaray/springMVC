package com.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.dao.BaseDAO;
import com.tutorial.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BaseDAO baseDAO;
	
	@Override
	public void persist(Book book) {
		baseDAO.persist(book);
	}

	@Override
	public List<Book> getAll() {
		return baseDAO.getAll(Book.class);
	}

}
