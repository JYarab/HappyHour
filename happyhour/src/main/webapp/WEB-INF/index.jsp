
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
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Happy Hour Welcome Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a66dc40b69.js" crossorigin="anonymous"></script>
</head>
<body>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Home </a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#"> My Bar</a>
						</li>		
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Favorites</a>
						</li>	
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#"> Browse Drinks</a>
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
	<div class="search-container">
	<h1>What's on Hand</h1>
		<div class="row">
		<span class="drinkSearch">
			<form action="/">
				<input class="search-text" type="text" name="searchTerm" id="searchTerm" placeholder="enter an ingredient..." style="">
				<input type="hidden" name="search" value="i" />
				<button class="btn btn-secondary">Search</button>
			</form>
		</span>
		</div>
		<div class="row">
		
			<c:forEach items="${drinkList}" var="drink">
				
				<div class="row border">
					<div class="col text-end">
				<img src="${drink.imgThumb}" width="100px" alt="" />
					</div>
					<div class="col">
				<p>Name: ${drink.name}</p>
				<c:if test="${pantry.containsAll(drink.getIngredientList())}">
				<p style="color: green; font-size: 20px;">You can make this drink!</p>
				</c:if>
				
				<p>Drink ID: ${drink.apiId}</p>
							
				
				<p>
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
			</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>