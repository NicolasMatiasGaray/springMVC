package com.tutorial.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tutorial.dao.BookDAO;
import com.tutorial.model.Book;

@RunWith(MockitoJUnitRunner.class)
public class TestBookService {

	@Mock
	private BookDAO bookDAO; 
	
	@InjectMocks
	private BookService bookService = new BookServiceImpl();
	
	@Test
	public void testPersist() {
		Book book = new Book();
        book.setTitle("Harry Potter y el Misterio de la Service Layer");
        book.setPrice(50d);
        
        doNothing().when(bookDAO).persist(book);
        
        bookService.persist(book);
       
        verify(bookDAO).persist(book);
	}
	
	@Test
	public void testGetAll() {
		Book book = new Book();
        book.setTitle("Harry Potter y el Misterio de la Service Layer");
        book.setPrice(50d);
        
        when(bookDAO.getAll()).thenReturn(Arrays.asList(book));
        
        List<Book> listBook= bookService.getAll();
        
        assertEquals(book.getTitle(), listBook.get(0).getTitle());
        assertEquals(1, listBook.size());
        verify(bookDAO).getAll();
	}

}
