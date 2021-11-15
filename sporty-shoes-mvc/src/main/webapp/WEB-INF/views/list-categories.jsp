<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.simplilearn.workshop.model.Products" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Categories</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PRM - Category Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Category -->
			<a href="${pageContext.request.contextPath}/index.jsp">Back to Index</a> <br><br>
			<input type="button" value="Add Category"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<!--  add our html table here -->
			
		
			<table>
				<tr>
					<th>CategoryId</th>
					<th>ProductId</th>
					<th>Category Name</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our categories -->
				<c:forEach var="tempCategory" items="${categories}">
				
					<!-- Category: construct an "update" link with category id -->
					<c:url var="updateLink" value="/categories/showFormForUpdate">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>					

					<!-- Category: construct an "delete" link with category id -->
					<c:url var="deleteLink" value="/categories/delete">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>
					
					<tr>
						<td> ${tempCategory.id} </td>
						<td> ${tempCategory.productId} </td>
						<td> ${tempCategory.category} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>