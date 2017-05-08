<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>

</head>
<body>

<h2>Customer List</h2>

<table>
	<tr>
		<td>id</td>
		<td>email</td>
		<td>name</td>
		<td>age</td>
	</tr>
<c:forEach var="customer" items="${clist }">
	<tr>
		<td>${customer.id }</td>
		<td>${customer.email }</td>
		<td>${customer.name }</td>
		<td>${customer.age }</td>
	</tr>
</c:forEach>

</table>

</body>
</html>