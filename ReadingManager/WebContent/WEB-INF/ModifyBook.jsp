<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<title>ModifyBook</title>
</head>
<body>
<form method="post" action="ModifyBook" id="submitModify">
	<div id="Tittle">
			<h1>Modify the Book : </h1><span class="bold"><%= request.getParameter("idModify") %></span>
			<input type="hidden" name="idModifyBook" value="<%= request.getParameter("idModify") %>">
		</div>
		<br>
		<fieldset> 
			<legend>Information about Book to modify</legend>
			<div>
				<div>
					<label class="labelWidth80">Author</label> 
					<input type="text" id = "tbAuthor" name="tbAuthor" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Genre</label>
					<input type="text" id = "tbGenre" name="tbGenre" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Description</label>
					<input type="text" id = "tbDescription" name="tbDescription" class="tbWidth"/>
				</div>
			</div>
			<span id="errorField" class="requis"></span>
		</fieldset>
		
		
		<div id="Treatment">
			<div class="floatRight">
				<input type="button" value="Modify" id="submitButton" class="buttonStyle" onclick="FieldModifyBookVerifier();"/> 
			</div>
		</div>
	</form>
</body>
</html>