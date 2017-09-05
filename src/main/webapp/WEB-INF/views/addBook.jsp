<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Tutorial</title>
</head>
<body>

<h3>Add a Book</h3>

<springform:form commandName="book" action="/springMVC/saveBook">
Title : <springform:input path="title"/> <br>
Price : <springform:input path="price"/> <br>

<input type="submit" value="Add Book"/>

</springform:form>

</body>
</html>