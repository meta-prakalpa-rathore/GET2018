<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome!!</h1>
	<h2>You are successfully logged in!!</h2>
	
	<br/>
	<a href="<c:url value='/j_spring_security_logout' />" > Logout</a>
</body>
</html>