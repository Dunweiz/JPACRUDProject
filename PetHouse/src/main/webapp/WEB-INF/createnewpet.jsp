<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Pet</title>
</head>
<body>
<form action="create.do" method="POST">
	<label for="type">Type:</label><iput type="text" name="type">
	<br> 
	<label for="name">Name:</label> <input type="text" name="name">
	<br>
	<label for="age">Age:</label> <input type="number"
	name="age">
	<input type="submit" value="Add">
</form>

</body>
</html>