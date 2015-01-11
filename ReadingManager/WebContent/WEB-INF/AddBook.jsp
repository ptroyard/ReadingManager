<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<title>Add a Book</title>
</head>

<body>
	<form method="post" action="AddBook" id="Submit">
		<div id="Tittle">
			<h1>Create a new Book</h1>
		</div>
		
		<fieldset> 
			<legend>Information about Book</legend>
			<div>
				<div>
					<label class="labelWidth80 ">Title <span class="requis inlineBlock">*</span></label>
					<input type="text" name="tbTitle" id= "tbTitle" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Author <div class="requis inlineBlock">*</div></label> 
					<input type="text" name="tbAuthor" id = "tbAuthor" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Genre <div class="requis inlineBlock">*</div></label>
					<input type="text" name="tbGenre" id= "tbGenre" class="tbWidth"/>
				</div>
				<div>
					<label class="labelWidth80">Description</label>
					<input type="text" name="tbDescription" class="tbWidth"/>
				</div>
			</div>
			<p id="errorNullField" class="requis"></p>
		</fieldset>
		
		<div id="Treatment">
			<div class="floatRight">
				<button type="button" id="btnSend" onclick="FieldVerifierAddBook();" class="buttonStyle">Register</button> 
			</div>
		</div>
	</form>
</body>


