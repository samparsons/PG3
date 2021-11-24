<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Manage Categories</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-admin-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>PRM - Category Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Category</h3>
	
		<form:form action="saveCategory" modelAttribute="category" method="POST">

			<!-- need to associate this data with admin id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Product Id:</label></td>
						<td><form:input path="productId" /></td>
					</tr>
					<tr>
						<td><label>Category Name:</label></td>
						<td><form:input path="category" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/categories/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>