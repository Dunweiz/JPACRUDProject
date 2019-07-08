<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Pet</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty pet }">
			<h1>${pet.name}</h1>
			<ul>
				<li>age: ${pet.age}</li>
				<li>type: ${pet.type}</li>
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