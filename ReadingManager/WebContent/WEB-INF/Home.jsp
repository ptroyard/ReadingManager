<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<title>Home</title>
</head>
<body>

	<div id="bloc_page">
		<section>
			<h1>Welcome ${user.firstName}</h1>
			This web application allows you to rate books and find matches
			among the other users based on what they like 
		</section>

	</div>
	
</body>
</html>