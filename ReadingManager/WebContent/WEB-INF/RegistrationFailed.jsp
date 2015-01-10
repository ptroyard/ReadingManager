<!-- Page called when a registration doesn't go well -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<title>Registration failed</title>
</head>
<body>
<div align="center">
	<h3 class="error">Registration failed: </h3>
	<p>${registrationError}</p>
</div>
</body>
</html>