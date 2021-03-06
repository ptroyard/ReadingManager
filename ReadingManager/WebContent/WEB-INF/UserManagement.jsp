<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<jsp:include page="header.jsp" />
<title>UserManagement</title>
</head>
<body>

	<div id="bloc_page">
		<section>
			<h1>User Management</h1>
			<button type="button" id="btnSearch" onclick="return hiddenSection('SearchTable');" class="buttonStyle">Search a user</button>
			<br>
			<form method="post" action="SearchResults" id="searchSubmit">
				<fieldset  id="SearchTable" style="display:none">
					<table>
							<tr class="tableTextBlue">
						       <th>Mail <input type="text" id ="tbSearchByMail" name="tbSearchByMail" class="marginTop30px marginBottom10px tbWidth "> </th>
						       <th>First Name <input type="text" id ="tbSearchByFirstName" name="tbSearchByFirstName" class="marginBottom10px tbWidth "> </th>
						       <th>Last name <input type="text" id ="tbSearchByLastName" name="tbSearchByLastName" class="marginBottom10px tbWidth "></th>
						       <th>Address <input type="text" id ="tbSearchByAddress" name="tbSearchByAddress" class="marginBottom10px tbWidth "></th>
						       <th>Phone number <input type="text" id ="tbSearchByPhone" name="tbSearchByPhone" class="marginBottom10px tbWidth "></th>
						   		<th>
						   		<button type="button" onclick="FieldSearchVerifier();" class="buttonStyle">Search</button> 
						   		</th>
						   </tr>
					</table>
					<span id="errorField" class="requis inlineBlock"></span>
				</fieldset>
				
			</form>
			
			<br><a href="Inscription"><img src="img/add.png" alt="Add" id="perso" class="addButtonStyle"/><h2 class="inlineBlock">Add a User</h2></a>
			<h2>Existing users list</h2>
				<div class="marginLeft15pourcent">
					<table>
					   <col width="300">
					   <col width="150">
					   <col width="150">
					   <col width="300">
					   <col width="130">
					   <col width="50">
					   <tr class="tableTextBlue">
					       <th>Mail</th>
					       <th>First Name</th>
					       <th>Last name</th>
					       <th>Address</th>
					       <th>Phone number</th>
					   </tr>
					   
					   
					   <c:forEach items="${userList}" var="item" varStatus="count">
						   <tr class="tableTextBlue">
					       <th>${item.mail}</th>
					       <th>${item.firstName}</th>
					       <th>${item.lastName}</th>
					       <th>${item.adress}</th>
					       <th>${item.tel}</th>
					       <td>
								<img src="img/modifyTable.png" id="${item.mail}" alt="Modify"  class="modifyButtonStyle" onclick="LinkAdaptatorToModify(this.id);"/>
					       		<img src="img/deleteTable.png" id="${item.mail}"  alt="Delete"  class="deleteButtonStyle" onclick="LinkAdaptatorToDelete(this.id);"/>
					       </td>
					   </tr>
						</c:forEach>
					</table>
				</div>

			
</body>
</html>