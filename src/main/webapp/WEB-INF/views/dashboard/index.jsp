<%@ include file="../global/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h1>Welcome: ${message}</h1>
    <c:forEach items="${users}" var="user" varStatus="loop">
    	<c:set var="count">${loop.index + 1}</c:set>
    	<div>${count} ${user.fullName} (${user.username})</div>
    </c:forEach>
</body>
</html>