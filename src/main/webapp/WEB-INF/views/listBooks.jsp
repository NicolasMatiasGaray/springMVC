<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Tutorial</title>
</head>
<body>

	<h2>Book Saved</h2>
	<hr> 
	List of Books: <br>

	<table border="1">
		<c:forEach items="${listBooks}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>