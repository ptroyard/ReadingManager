<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Verify Email</title>
</head>
<body>
<%
String message="";
boolean status = (boolean) session.getAttribute("status") ;
if(status == true){
	message= "Email has already been verified!";
}
else if(status == false){
	message ="Email verified!";
} 
else{
	%>response.sendRedirect("error.jsp")
<%} 
%>
<h1 class="success"><%= message %></h1>
<a href="Connexion.jsp">Sign in</a>
</body>
</html>