<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h3>Edit Pet</h3>

	<h1>${petHouse.name}</h1>
	<ul>
		<li>Type: ${petHouse.type}</li>
		<li>Age: ${petHouse.age}</li>
	</ul>
	<br>
	<form action="update.do" method="POST">
		<label for="name">Name:</label><input type="text" name="name"
			value="${petHouse.name}"> <label for="type">Type:</label><input
			type="text" name="type" value="${petHouse.type}"> <label
			for="age">Age:</label><input type="number" name="age"
			value="${petHouse.age}"> <input type="hidden" name="id"
			value=${petHouse.id}> <input type="submit" value="Update">
	</form>
	<a href="index.jsp">Go Home</a>
</body>
</html>