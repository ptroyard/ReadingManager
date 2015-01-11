<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="header.jsp" />
<script type="text/javascript" src="JavaScript/Javascript.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<h2>Result of your search</h2>
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
								<img src="img/modifyTable.png" id="${item.title}" alt="Modify"  class="modifyButtonStyle" onclick="LinkAdaptatorToModify(this.id);"/>
					       		<img src="img/deleteTable.png" id="${item.title}"  alt="Delete"  class="deleteButtonStyle" onclick="LinkAdaptatorToDelete(this.id);"/>
					       </td>
					   </tr>
						</c:forEach>
					</table>
				</div>
</body>
</html>