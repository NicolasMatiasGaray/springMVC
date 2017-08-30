package com.tutorial.dao;

import java.util.List;

public interface BaseDAO {

	public void persist(Object obj);
	
	public <T> List<T> getAll(Class<T> clazz);
}
