package com.tutorial.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.model.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Book book) {
		sessionFactory.getCurrentSession().persist(book);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

}
