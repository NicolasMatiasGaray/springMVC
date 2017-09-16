package com.tutorial.dao;

import static org.junit.Assert.*;

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
public class TestBookDAO {

	@Autowired
    private BookDAO bookDAO;

    @Test
    @Transactional
    @Rollback(true)
    public void testPersist()
    {
        Book book = new Book();
        book.setTitle("Harry Potter y el Misterio de los Unit Test");
        book.setPrice(200d);
        
        bookDAO.persist(book);
        
        List<Book> listBook = bookDAO.getAll();
        assertEquals(1, listBook.size());
        assertEquals(book.getTitle(), listBook.get(0).getTitle());
    }
}
