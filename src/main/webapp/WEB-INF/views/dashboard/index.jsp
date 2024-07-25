<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../global/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>Welcome: ${message}</h1>

<ul>
	<c:forEach items="${users}" var="user" varStatus="loop">
	<c:set var="count">${loop.index + 1}</c:set>
		<li>${count} ${user.fullName}</li>
	</c:forEach>
</ul>
</body>
</html>