<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Show Pet</title>
</head>
<body background="https://www.petsadvice.org/wp-content/uploads/2018/08/An-All-New-World-For-Pets-Online.jpg">
	<c:choose>
		<c:when test="${! empty pet }">
<div class="header">
			<h1>${pet.name}</h1>
			<ul>
				<li>Age: ${pet.age}</li>
				<li>Type: ${pet.type.species}</li>
			</ul>
			</div>
			<hr>
			<h2> Pet Owners Information</h2>
			<ul>	
				<li>First Name: ${pet.owner.firstName }</li>
				<li>Last Name: ${pet.owner.lastName }</li>
				<li>Phone Number: ${pet.owner.phone }</li>
				<li>Address: ${pet.owner.address.address }</li>
				<li>City: ${pet.owner.address.city }</li>
				<li>State: ${pet.owner.address.state }</li>
				<li>Zip-Code: ${pet.owner.address.zip}</li>
			</ul>
			<hr>
			<form action="updatePage.do" method="GET">
				<input type="hidden" name="PID" value=${pet.id}> <input
					type="submit" value="Edit Pet">Edit Pet Information<br>
			</form>
			<hr>
			<form action="delete.do" method="POST"> <h1></h1>
				<input type="hidden" name="PID" value=${pet.id}> <input
					type="submit" value="Delete Pet">Delete Pet <br>
			</form>
		</c:when>
		<c:otherwise>
			<p>No Pets Found</p>
		</c:otherwise>
	</c:choose>
			<hr>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>