<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Products</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PRM - Product Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Product -->
		   	<a href="${pageContext.request.contextPath}/admin-portal.jsp">Back to Portal</a> <br><br>
			<input type="button" value="Add Product"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Product Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Image Path</th>
					<th>Image</th>
					<th>Categories</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our products -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- Product: construct an "update" link with product id -->
					<c:url var="updateLink" value="/products/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					

					<!-- Product: construct an "delete" link with product id -->
					<c:url var="deleteLink" value="/products/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					
					
					<tr>
						<td> ${tempProduct.id} </td>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.description} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.imgPathURL} </td>
						<td> <img src="${tempProduct.imgPathURL}"> </td>
						<td>
						<c:forEach var="tempCategory" items="${tempProduct.categories}">
							<c:url var="deleteCatLink" value="/categories/delete">
								<c:param name="categoryId" value="${tempCategory.getId()}" />
							</c:url>
							<c:url var="updateCatLink" value="/categories/showFormForUpdate">
								<c:param name="categoryId" value="${tempCategory.getId()}" />
							</c:url>
							<div style="border-style:solid;">
								<span>${tempCategory.getCategory()} <a href="${updateCatLink}">edit</a> | <a href="${deleteCatLink}">delete</i></a></span>
							</div><br>
						</c:forEach>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>