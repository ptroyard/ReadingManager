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
		<title class="info">Inscription Treatment</title>
	</head>
	<body>
		<p class="succes">Registration succedeed</p>
		<p>An email has been sent to the user</p>
		<fieldset>
			<p><span class="labelWidth100 bold">Mail :</span>${createdUser.mail}</p>
			<p><span class="labelWidth100 bold">Last name :</span>${createdUser.lastName }</p>
			<p><span class="labelWidth100 bold">First name :</span>${createdUser.firstName }</p>
			<p><span class="labelWidth100 bold">Address :</span>${createdUser.adress}</p>
			<p><span class="labelWidth100 bold">Telephone :</span>${createdUser.tel}</p>
			<p><span class="labelWidth100 bold">Admin :</span>
			<c:if test="${createdUser.admin==false}">
				No
			</c:if>
			<c:if test="${createdUser.admin==true}">
				Yes
			</c:if>
			</p>
		</fieldset>
		<a href="Home">Return Home</a>
	</body>
</html>