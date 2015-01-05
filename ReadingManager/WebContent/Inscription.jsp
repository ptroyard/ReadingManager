<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<title>Inscription</title>
</head>

<body>
	<form method="post" action="InscriptionTreatment">
		<div id="Tittle">
			<h1>Create a new User</h1>
		</div>
		
		<fieldset> 
			<legend>Information about User</legend>
			<div>
				<div>
					<label class="labelWidth80">E-mail :</label>
					<input type="text" name="tbMail" class="tbWidth">
				</div>
				<div>
					<label class="labelWidth80">Name :</label> 
					<input type="text" name="tbName" class="tbWidth">
				</div>
				<div>
					<label class="labelWidth80">First Name :</label>
					<input type="text" name="tbFirstName" class="tbWidth">
				</div>
				<div>
					<label class="labelWidth80">Address :</label>
					<input type="text" name="tbAddress" class="tbWidth">
				</div>
				<div>
					<label class="labelWidth80">Telephone :</label>
					<input type="text" name="tbTelephone" class="tbWidth">
				</div>
			</div>
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
				<input type="submit" value = "SEND" id="btnSend" > 
				<button type="button" id="btnCancel" class="buttonStyle"> CANCEL</button>
			</div>
		</div>
	</form>
</body>
