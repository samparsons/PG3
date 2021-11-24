<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Purchases</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PRM - Purchase Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<a href="${pageContext.request.contextPath}/admin-portal.jsp">Back to Portal</a> <br><br>
			<form action="/purchases/searchByDateAndCategory" method="GET">
				<label >Date:</label>
				<select name="date">
				<c:forEach var="tempPurchase" items="${purchases}">
					<option value="${tempPurchase.purchaseDate}">${tempPurchase.purchaseDate}</option>
				</c:forEach>
				</select>
				<label>Category:</label>
				<input type="text" name="category" />
				<input type="submit" value="Submit" />
			</form>
			<br>
			<a href="/purchases/list">Clear Search</a>
			<br><br>	
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Product Id</th>
					<th>Customer Id</th>
					<th>Purchase Date</th>
					<th>Price</th>
					<th>Categories</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our purchases -->
				<c:if test = "${purchases.size() == 0}">
				<tr>
						<td colspan=6>No results - <a href="/purchases/list">Go back</a></td>
				</c:if>
				<c:forEach var="tempPurchase" items="${purchases}">

					<!-- Purchase: construct an "delete" link with purchase id -->
					<c:url var="deleteLink" value="/purchases/delete">
						<c:param name="purchaseId" value="${tempPurchase.purchaseId}" />
					</c:url>
					
					
					
					<tr>
						<td> ${tempPurchase.productId} 		</td>
						<td> ${tempPurchase.customerId} 	</td>
						<td> ${tempPurchase.purchaseDate} 	</td>
						<td> ${tempPurchase.price} 			</td>
						<td>
						<c:forEach var="tempCategory" items="${tempPurchase.categories}">
							<div style="border-style:solid;">
								<span>${tempCategory.getCategory()}</span>
							</div><br>
						</c:forEach>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this purchase?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>