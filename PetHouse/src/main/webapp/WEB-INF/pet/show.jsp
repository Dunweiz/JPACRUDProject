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
		<c:when test="${! empty pethouse }">
			<h1>${pethouse.name}</h1>
			<ul>
				<li>age: ${pethouse.age}</li>
				<li>type: ${pethouse.type}</li>
			</ul>
			<form action="updatePage.do" method="POST">
				<input type="hidden" name="PID" value=${pethouse.id}> <input
					type="submit" value="Edit PetHouse">Edit Pet Information<br>
			</form>
			<form action="delete.do" method="POST">
				<input type="hidden" name="PID" value=${pethouse.id}> <input
					type="submit" value="Delete PetHouse">Delete Pet <br>
			</form>
		</c:when>
		<c:otherwise>
			<p>No Pets Found</p>
		</c:otherwise>
	</c:choose>


	<a href="index.html">Go Home</a>
</body>
</html>