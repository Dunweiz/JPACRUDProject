<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>update page</title>
</head>
<body background="https://campfire.org/wp-content/uploads/2016/08/e6bffcd2e194a6b1b8317b8f5126f7a409e150d6_Home-slider-2_v2.jpg">
	<div class="header">
	<h2>Edit Pet Information</h2>
	</div>
	<hr>
	<h1>Pet Name: ${pet.name}</h1>
	<ul>
		<li>Type: ${pet.type.species}</li>
		<li>Age: ${pet.age}</li>
		<li>First Name: ${pet.owner.firstName }</li>
		<li>Last Name: ${pet.owner.lastName }</li>
		<li>Phone Number: ${pet.owner.phone }</li>
		<li>Address: ${pet.owner.address.address }</li>
		<li>City: ${pet.owner.address.city }</li>
		<li>State: ${pet.owner.address.state }</li>
		<li>Zip-Code: ${pet.owner.address.zip}</li>
	</ul>
	<hr>
	<br>
	<form action="update.do" method="POST">
		<label for="name">Name:</label><input type="text" name="name"
			value="${pet.name}"> <br> 
			
			<label for="type.id">Type:</label>
		<br>
		<input type="radio" name="type.id" value="1"> Canine <br>
		<input type="radio" name="type.id" value="2"> Feline <br>
		<input type="radio" name="type.id" value="3"> Bird <br>
		<input type="radio" name="type.id" value="4"> Rodent <br>
		<input type="radio" name="type.id" value="5"> Fish <br>
		<input type="radio" name="type.id" value="6"> Reptile <br>

		<label for="age">Age:</label><input type="number" name="age"
			value="${pet.age}"> <br>
		
		<hr>
		<h2>Pet Owner Information</h2>
		
		<input type="hidden" value="${pet.owner.id}" name="owner.id">
		<input type="hidden" value="${pet.owner.address.id}" name="owner.address.id">
		
		<br> <label for="owner.firstName">First Name: </label> <input
			type="text" name="owner.firstName" value="${pet.owner.firstName}">
		
		<br> <label for="owner.lastName">Last Name: </label> <input
			type="text" name="owner.lastName" value="${pet.owner.lastName}">
		
		<br> <label for="owner.phone">Phone Number: </label> <input
			type="text" name="owner.phone" value="${pet.owner.phone}">
			
		<br> <label for="owner.address.address">Address: </label> <input
			type="text" name="owner.address.address" value="${pet.owner.address.address}">
			
		<br> <label for="owner.address.city">City: </label>	<input
			type="text" name="owner.address.city" value="${pet.owner.address.city}">
			
		<br> <label for="owner.address.state">State: </label> <input
			type="text" name="owner.address.state" value="${pet.owner.address.state}">
			
		<br> <label for="owner.address.zip">Zip-Code: </label> <input
			type="text" name="owner.address.zip" value="${pet.owner.address.zip}">		
		
		<br> <input type="hidden" name="PID" value="${pet.id}"> <input
			type="submit" value="Update">

	</form>
	<hr>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>