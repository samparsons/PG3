<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		   	<a href="${pageContext.request.contextPath}/admin-portal.jsp">Back to Portal</a> <br><br>
		   	
	
		<form action="/customers/searchbynameasc" method="GET">
			<label>Name:</label>
			<input type="text" name="name" />
			<input type="submit" value="Search" />
		</form>
		<br>
		<a href="/customers/list">Clear Search</a>
		<br><br>	
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- Customer: construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customers/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					

					<!-- Customer: construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customers/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					
					
					<tr>
						<td> ${tempCustomer.getName()} </td>
						<td> ${tempCustomer.phone} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.username} </td>
						<td class="password"> ${tempCustomer.password} </td>
						<td>	<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>