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

	<h1>${pet.name}</h1>
	<ul>
		<li>Type: ${pet.type}</li>
		<li>Age: ${pet.age}</li>
	</ul>
	<br>
	<form action="update.do" method="POST">
		<label for="name">Name:</label><input type="text" name="name"
			value="${pet.name}"> <label for="type">Type:</label><input
			type="text" name="type" value="${pet.type}"> <label
			for="age">Age:</label><input type="number" name="age"
			value="${pet.age}"> 
			<input type="hidden" name="PID" value="${pet.id}">
			 <input type="submit" value="Update">
	</form>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>