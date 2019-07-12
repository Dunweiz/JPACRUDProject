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
	<label for="type.id">Type:</label>
		<br>
		<input type="radio" name="type.id" value="1"> Canine <br>
		<input type="radio" name="type.id" value="2"> Feline <br>
		<input type="radio" name="type.id" value="3"> Bird <br>
		<input type="radio" name="type.id" value="4"> Rodent <br>
		<input type="radio" name="type.id" value="5"> Fish <br>
		<input type="radio" name="type.id" value="6"> Reptile <br>
	<br> 
	<label for="name">Name:</label> <input type="text" name="name">
	<br>
	<label for="age">Age:</label> <input type="number"
	name="age">
		<hr>
		<h2>Pet Owner Information</h2>
		
		<br> <label for="owner.firstName">First Name: </label> <input
			type="text" name="owner.firstName">
		
		<br> <label for="owner.lastName">Last Name: </label> <input
			type="text" name="owner.lastName">
		
		<br> <label for="owner.phone">Phone Number: </label> <input
			type="text" name="owner.phone">
			
		<br> <label for="owner.address.address">Address: </label> <input
			type="text" name="owner.address.address">
			
		<br> <label for="owner.address.city">City: </label>	<input
			type="text" name="owner.address.city">
			
		<br> <label for="owner.address.state">State: </label> <input
			type="text" name="owner.address.state" >
			
		<br> <label for="owner.address.zip">Zip-Code: </label> <input
			type="text" name="owner.address.zip" >		
		
	
	<input type="submit" value="Add">
</form>
<hr>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>