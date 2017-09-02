package com.tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDAOImpl implements BaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Object obj) {
		sessionFactory.getCurrentSession().persist(obj);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> clazz) {
		List<T> list = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
		return list;
	}

}
