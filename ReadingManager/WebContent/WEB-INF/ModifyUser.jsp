<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<title>ModifyUser</title>
</head>
<body>
<form method="post" action="ModifyUser">
	<div id="Tittle">
			<h1>Modify the User : </h1><span class="bold"><%= request.getParameter("idModify") %></span>
			<input type="hidden" name="idModifyUser" value="<%= request.getParameter("idModify") %>">
		</div>
		<br>
		<fieldset> 
			<legend>Information about User to modify</legend>
			<div>
				<div>
					<label class="labelWidth80">Name</label> 
					<input type="text" name="tbName" id = "tbName" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">First Name</label>
					<input type="text" name="tbFirstName" id= "tbFirstName" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Address</label>
					<input type="text" name="tbAddress" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Telephone</label>
					<input type="text" name="tbTelephone" class="tbWidth"/>
				</div>
			</div>
			<p id="errorNullField" class="requis"></p>
		</fieldset>
		
		<fieldset> 
			<legend>Specificities</legend>
				<div>
				Resources : 
					<input type="radio" name="rbAdmin" value="Reader" checked> Reader
					<input type="radio" name="rbAdmin" value="Administrator" > Administrator
				</div>
		</fieldset>
		
		<div id="Treatment">
			<div class="floatRight">
				<input type="submit" value="Modify" id="submitButton" class="buttonStyle"/> 
			</div>
		</div>
	</form>
</body>
</html>