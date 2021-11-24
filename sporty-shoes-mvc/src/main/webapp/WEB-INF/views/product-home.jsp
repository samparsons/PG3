<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Sporty Shoes</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a href="#" class="navbar-brand">Sporty Shoes</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="toggle-navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse-navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a href="index.jsp" class="nav-link">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a href="/admin-login.jsp" class="nav-link">Admin Portal</a>
          </li>
        </ul>

      </div>
    </nav>
    <div class="jumbotron">
        <h class="display-4">Welcome to Sporty Shoes</h>
        <p class="lead">This is a shoe company POC created by Sam Parsons for the course named "PG FSD Implement Frameworks the DevOps way"</p>
    </div>
    <div class="card">
      <div class="row">
      	<c:forEach var="tempProduct" items="${products}" varStatus="itemLoop">	
				<div class="col-sm-4">
					<div class="card">
						<div class="card-body">
					      	<img class="card-img-top" src="${tempProduct.imgPathURL}" alt="Card image cap">
					        <h5 class="card-title">${tempProduct.name}</h5>
					        <p class="card-text">${tempProduct.description} <br> 
					        <c:forEach var="tempCategory" items="${tempProduct.categories}">
							  <span class="badge badge-secondary">${tempCategory.getCategory()}</span>
						    </c:forEach>
					        </p>
					         <a href="/index.jsp" class="btn btn-primary"
					       		onclick="$alert("Please Select Your favorite tshirts size")">$${tempProduct.price}</a>
					    </div>
				    </div>
				</div> 
      		<c:if test="${(itemLoop.count % 3 == 0)}">
      		</div>
      		<div class="row">
      		</c:if>
		</c:forEach>
		</div>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>