<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/CSSManager.css" />
</head>
<body>

	<header> 
	<img src="img/ReadingManager_ico.png" alt="ReadingManager Logo" id="logo" class="logoStyle" />
		<a href="Home">
		<h1 class="headerTitleStyle">Reading Manager</h1></a>
		<div class="right">
			<img src="img/user.png" alt="ReadingManager Perso" id="perso" /> ${ user.firstName } ${ user.lastName }
				<form action="${pageContext.request.contextPath}/Logout" method="post" class="display: inline-block;">
					<input type="submit" name="logout" value="Log Out" class="buttonStyle" />
				</form>
		</div>
		
		<!-- Display the good header (Admin/user) -->
 		<c:if test="${user.admin==true}">
 			<jsp:include page="AdminHeader.jsp" />
 		</c:if>
 		<c:if test="${user.admin==false}">
 			<jsp:include page="UserHeader.jsp" />
 		</c:if>
	</header>
	
</body>
</html>

