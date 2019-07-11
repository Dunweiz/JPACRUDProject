<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body><h1>Pet House</h1>
<form action="getPet.do" method="GET">
		Pet ID: <input type="number" name="pid" /> <input type="submit"
			value="Show Pets" />
	</form>
	<hr>
		<c:forEach var="p" items="${pets}">
			<li><a href="getPet.do?pid=${p.id}">${p.name}(${p.type})</a></li>
		</c:forEach>
	<hr>
	<form action="createPage.do" method="GET">
		Create New Pet: <input type="Submit" Value="Add New pet">
	</form>
</body>
</html>