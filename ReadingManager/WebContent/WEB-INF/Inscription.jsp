<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<title>Inscription</title>
</head>

<body>
	<form method="post" action="Inscription" id="Submit">
		<div id="Tittle">
			<h1>Create a new User</h1>
		</div>
		
		<fieldset> 
			<legend>Information about User</legend>
			<div>
				<div>
					<label class="labelWidth80 ">E-mail <span class="requis inlineBlock">*</span></label>
					<input type="text" name="tbMail" id= "tbMail" class="tbWidth"/>
					<span id="errorMail" class="requis inlineBlock"></span>
				</div>
				<div>
					<label class="labelWidth80">Name <div class="requis inlineBlock">*</div></label> 
					<input type="text" name="tbName" id = "tbName" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">First Name <div class="requis inlineBlock">*</div></label>
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
				<button type="button" id="btnSend" onclick="FieldVerifierInscription();" class="buttonStyle">Register</button> 
			</div>
		</div>
	</form>
</body>


