<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<form action="getPet.do" method="GET">
		Pet ID: <input type="text" name="pid" /> <input type="submit"
			value="Show Pets" />
	</form>
	<hr>
		<c:forEach var="p" items="${pets}">
			<li><a href="getPet.do?fid=${p.id}">${p.type}</a></li>
		</c:forEach>
</body>
</html>