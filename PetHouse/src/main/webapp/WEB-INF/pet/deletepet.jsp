<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
		<c:when test="${empty pet }">
		<h2>Pet Deleted</h2>
		</c:when>
		<c:otherwise>Pet Cannot Be Deleted</c:otherwise>
	</c:choose>
	<br>
	 <a href="index.jsp">Go Home</a>
</body>
</html>