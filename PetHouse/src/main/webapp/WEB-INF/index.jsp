<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body background="https://www.condorferries.co.uk/media/2455/taking-your-pet-5.jpg">
<div class="header">
<h1>Pet House</h1>
<form action="getPet.do" method="GET">
		Pet ID: <input type="number" name="pid" /> <input type="submit"
			value="Show Pets" />
	</form>

</div>
	<hr>
		<ul>
		<c:forEach var="p" items="${pets}">
			<li ><a href="getPet.do?pid=${p.id}">${p.name}(${p.type.species})</a></li>
		</c:forEach>
		</ul>
	<hr>
	<form action="createPage.do" method="GET">
		Create New Pet: <input type="Submit" Value="Add New pet">
	</form>
</body>
</html>