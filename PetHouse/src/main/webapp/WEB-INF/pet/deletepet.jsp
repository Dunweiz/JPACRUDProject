<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body background="https://cdn.pixabay.com/photo/2015/11/29/19/23/bulldog-1069212_960_720.jpg">
<c:choose>
		<c:when test="${!empty pet}">
		<h2>Pet Deleted</h2>
		</c:when>
		<c:otherwise>Pet Cannot Be Deleted</c:otherwise>
	</c:choose>
	<br>
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>
</body>
</html>	