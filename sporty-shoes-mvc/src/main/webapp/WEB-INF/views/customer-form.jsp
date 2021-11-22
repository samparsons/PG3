<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Manage Customers</title>

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
			<h2>PRM - Customer Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	   
	   
	   
		<form:form action="/customers/searchbynameasc" modelAttribute="customer" method="POST">

			<!-- need to associate this data with admin id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>
					
					<tr>
						<td><label>Image Url:</label></td>
						<td><form:input path="imgPathURL" /></td>
					</tr>
					<tr>
						<td><label>Categories:</label></td>
						<td>After saving this customer, you may add categories from the customer manager interface.</td>
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
			<a href="${pageContext.request.contextPath}/admins/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>