
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!-- JSP functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Happy Hour Welcome Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"crossorigin="anonymous">
<!-- Local CSS -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a66dc40b69.js" crossorigin="anonymous"></script>
</head>
<body>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="/happyhour">Home </a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/happyhour/mybar"> My Bar</a>
						</li>		
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Favorites</a>
						</li>	
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/luckyDrink"> Browse Drinks</a>
						</li>	
					</ul>
				</div>
				<c:choose>
				<c:when test="${loggedUser.id != null}">
					<a class="navbar-brand" href="/logout"> Logout </a>
				</c:when>
				<c:otherwise>
					<a class="navbar-brand" href="/login"> Login </a>
				</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</div>
	
	<div class="container">
	
		<div class="row justify-content-center">
		<h1>What's on Hand</h1>
			<div class="col-6">
			<form action="/happyhour">
				<div class="input-group justify-content-center">
				<input type="text" name="searchTerm" id="searchInput" class="form-control" placeholder="Search a drink by...">
				<select class="form-select" id="searchType" name="searchType" class="rounded-end">
				    <option value="name">Name</option>
				    <option value="ingredient">Ingredient</option>
				    <option value="3">Three</option>
				  </select>
				</div>				
				<div class="text-center">
					<button class="btn btn-secondary">Search</button>
				</div>
			</form>
			</div>
		</div>
	</div>
		
<!-- Search Results Go Here -->		
	<div class="container">
		<h4>${fn:length(drinkList)} Results</h4>
		<div class="row g-3">
			<c:forEach items="${drinkList}" var="drink">				
				<div class="col-12 col-md-6 col-lg-4">
					<div class="card">
						<a href="/drinks/${drink.apiId}"><img src="${drink.imgThumb}" class="card-img-top" alt="" /></a>
					    <div class="card-body">
						    <h5 class="card-title"><a href="/drinks/${drink.apiId}">${drink.name}</a></h5>
						    <c:if test="${pantry.containsAll(drink.getIngredientList())}">
								<p class="card-text" style="color: green; font-size: 20px;">You can make this drink!</p>
							</c:if>
							<p class="card-text"><small class="text-muted">
								<c:forEach items="${drink.getIngredientList()}" var="ingredient">
									<span
									<c:choose>
										<c:when test="${pantry.contains(ingredient)}"> 
											style="color: green;"
										</c:when>
										<c:otherwise>
											style="color: red;"
										</c:otherwise>
									</c:choose>>
									${ingredient},
									</span>
								</c:forEach>
								</small>
							</p>
						</div>
					</div>							
				</div>							
			</c:forEach>
		</div>
		
	</div>
</body>
</html>