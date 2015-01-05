<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LuckyDay</title>
</head>
<body>
	<%
		int lower = 0;
		int higher = 10;
		int randomNumber = (int) (Math.random() * (higher - lower)) + lower;
		if (randomNumber > 5) {
	%>T'es raide
	<%
		} 
		else 
		{
	%>
	gagné<%
		}
	%>

	<%=randomNumber%>

	<a href="">Try Again</a>
</body>
</html>

