<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<jsp:include page="header.jsp" />
<title>BookManagement</title>
</head>
<body>

	<div id="bloc_page">
		<section>
			<h1>Book Management</h1>
			<button type="button" id="btnSearch" onclick="return hiddenSection('SearchTable');" class="buttonStyle">Search a book</button>
			<br>
			<form method="post" action="SearchBookResults" id="searchSubmit">
				<fieldset  id="SearchTable" style="display:none">
					<table>
							<tr class="tableTextBlue">
						       <th>Title <input type="text" id ="tbSearchByTitle" name="tbSearchByTitle" class="marginTop30px marginBottom10px tbWidth "> </th>
						       <th>Author <input type="text" id ="tbSearchByAuthor" name="tbSearchByAuthor" class="marginBottom10px tbWidth "> </th>
						       <th>Genre <input type="text" id ="tbSearchByGenre" name="tbSearchByGenre" class="marginBottom10px tbWidth "></th>
						       <th>Description <input type="text" id ="tbSearchByDescription" name="tbSearchByDescription" class="marginBottom10px tbWidth "></th>
						   		<th>
						   		<button type="button" onclick="FieldSearchBookVerifier();" class="buttonStyle">Search</button> 
						   		</th>
						   </tr>
					</table>
					<span id="errorField" class="requis inlineBlock"></span>
				</fieldset>
				
			</form>
			
			<br><a href="AddBook"><img src="img/add.png" alt="Add" id="perso" class="addButtonStyle"/><h2 class="inlineBlock">Add a Book</h2></a>
			<h2>Existing Book list</h2>
				<div class="marginLeft15pourcent">
					<table>
					   <col width="300">
					   <col width="150">
					   <col width="150">
					   <col width="400">
					   <col width="50">
					   <tr class="tableTextBlue">
					       <th>Title</th>
					       <th>Author</th>
					       <th>Genre</th>
					       <th>Description</th>
					   </tr>
					   
					   
					   <c:forEach items="${bookList}" var="item" varStatus="count">
						   <tr class="tableTextBlue">
					       <th>${item.title}</th>
					       <th>${item.author}</th>
					       <th>${item.litteratureGenre}</th>
					       <th>${item.bookDescription}</th>
					       <td>
								<img src="img/modifyTable.png" id="${item.title}" alt="Modify"  class="modifyButtonStyle" onclick="LinkAdaptatorToModifyBook(this.id);"/>
					       		<img src="img/deleteTable.png" id="${item.title}"  alt="Delete"  class="deleteButtonStyle" onclick="LinkAdaptatorToDeleteBook(this.id);"/>
					       </td>
					   </tr>
						</c:forEach>
					</table>
				</div>

			
</body>
</html>