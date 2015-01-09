<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<title>Contact</title>
</head>
<body>

	<div id="bloc_page">
		<section>
			<h1>Contact us</h1>
			<p>If you have any question about our website, please fill the form below and submit it :</p>
			<form method="POST" action="ContactUS">
			    <label for="subject">Subject:</label><input id="subject" name="subject" type="text"/><br/>
			    <textarea name="body" cols="60" rows="15"></textarea><br/>
			    <input type="submit" value="Send"/>
			</form>
		</section>

	</div>

</body>
</html>