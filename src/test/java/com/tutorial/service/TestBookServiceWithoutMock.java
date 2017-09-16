package com.tutorial.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.model.Book;

@ContextConfiguration(locations = "classpath:/com/tutorial/xml/applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBookServiceWithoutMock {

	@Autowired
	private BookService bookService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testPersistAndGetAll() {
		Book book = new Book();
        book.setTitle("Harry Potter y el Misterio de la Service Layer");
        book.setPrice(50d);
        
        bookService.persist(book);
        List<Book> listBook= bookService.getAll();
       
        assertEquals(book.getTitle(), listBook.get(0).getTitle());
        assertEquals(1, listBook.size());
	}
}
