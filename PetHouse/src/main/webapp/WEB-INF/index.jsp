<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="getPet.do" method="GET">
		Pet ID: <input type="text" name="pid" /> <input type="submit"
			value="Show Pets" />
	</form>
	<hr>
		<c:forEach var="p" items="${pets}">
			<li><a href="getPet.do?pid=${p.id}">${p.name}(${p.type}</a></li>
		</c:forEach>
</body>
</html>