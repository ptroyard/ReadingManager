<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" href="inc/ContactUS.css">
<title>Contact</title>
</head>
<body>
<section>
	<fieldset class="fieldsetAttributes">
	<form method="POST" action="ContactUS" class="elegant-aero">
	<table>
    <tr><td><h1>Contact us</h1></td></tr>
	<tr><td class="instructions">If you have any question about our website, please fill and submit the form :</td></tr>	
	<tr><td><span class="titre">Subject:</span></td> <td><input id="subject" name="subject" type="text"/></td></tr>
	<tr><td><span class="titre">Message:</span></td> <td><textarea name="body"></textarea></td></tr>
	<tr><td><input type="submit" value="Send"/></td></tr>
	</fieldset>
	</table>
	</form>
</section>

</body>
</html>