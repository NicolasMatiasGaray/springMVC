<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.tutorial.dao.BaseDAO" %>
<%@ page import="com.tutorial.model.Book" %>

<html>
<body>
<h2>Welcome To Book Store</h2>
<br>
<%
	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
	BaseDAO baseDAO = context.getBean(BaseDAO.class);
	Book book = new Book();
	book.setTitle("Harry Potter y el Misterio de Spring MVC");
	book.setPrice(100.99d);
	baseDAO.persist(book);
	
	for (Book b : baseDAO.getAll(Book.class)){
		out.print(b.getId() + " - " + b.getTitle() + " - " + b.getPrice() + "<br>");
	}
%>
</body>
</html>
