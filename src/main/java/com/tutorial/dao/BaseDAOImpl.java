package com.tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAOImpl implements BaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(obj);
		tx.commit();
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> clazz) {
		Session session = sessionFactory.openSession();
		List<T> list = session.createQuery("from " + clazz.getName()).list();
		session.close();
		return list;
	}

}
