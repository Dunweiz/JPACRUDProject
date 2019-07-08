<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Pet</title>
</head>
<body>
<h1>Add Pet Information</h1>
<form action="create.do" method="POST">
	<label for="type">Type:</label><input type="text" name="type">
	<br> 
	<label for="name">Name:</label> <input type="text" name="name">
	<br>
	<label for="age">Age:</label> <input type="number"
	name="age">
	<input type="submit" value="Add">
</form>
<hr>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>