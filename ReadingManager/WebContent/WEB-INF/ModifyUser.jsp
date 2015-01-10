<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<title>ModifyUser</title>
</head>
<body>
<form method="post" action="ModifyUser" id="submitModify">
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
					<input type="text" id = "tbName" name="tbName" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">First Name</label>
					<input type="text" id = "tbFirstName" name="tbFirstName" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Address</label>
					<input type="text" id = "tbAddress" name="tbAddress" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Telephone</label>
					<input type="text" id = "tbTelephone" name="tbTelephone" class="tbWidth"/>
				</div>
			</div>
			<span id="errorField" class="requis"></span>
		</fieldset>
		
		
		<div id="Treatment">
			<div class="floatRight">
				<input type="button" value="Modify" id="submitButton" class="buttonStyle" onclick="FieldModifyVerifier();"/> 
			</div>
		</div>
	</form>
</body>
</html>