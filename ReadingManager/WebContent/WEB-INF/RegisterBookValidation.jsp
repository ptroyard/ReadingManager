<!-- Page called to confirm a registration -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<jsp:include page="header.jsp" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="inc/CSSManager.css"/>
		<title class="info">Book Added Confirmation</title>
	</head>
	<body>
		<p class="succes">Registration succedeed</p>
		<fieldset>
			<p><span class="labelWidth100 bold">Title :</span>${createdBook.title}</p>
			<p><span class="labelWidth100 bold">Author :</span>${createdBook.author }</p>
			<p><span class="labelWidth100 bold">Genre :</span>${createdBook.litteratureGenre }</p>
			<p><span class="labelWidth100 bold">Description :</span>${createdBook.bookDescription}</p>
			</p>
		</fieldset>
		<a href="Home">Return Home</a>
	</body>
</html>