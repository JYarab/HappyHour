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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a66dc40b69.js" crossorigin="anonymous"></script>
<title>Luck Drink</title>
</head>
<body style="background-color:grey;">

	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-top:10px;">
  <a class="navbar-brand" href="/happyhour">Home</a>
</nav>

	<h1 style="text-align: center;">Random Drinks</h1>
	<div class="flex-container">
	<c:forEach items="${drinks}" var="drink">
  	<div class="card" style="width: 30rem;display:inline-flex;margin-left: 20px;">
    
    <div class="card-body" style="margin:0 20px 0 50px;">
    <img src="${drink.imgThumb}" class="card-img-top" alt="" width="300" height="300" />
      <h5 class="card-title">${drink.name}</h5>
      <p class="card-text">${drink.getIngredMeasure()}</p>
      <p class="card-text">${drink.instructions}</p>
    </div>
  </div> 
  </c:forEach>
	</div>


	
</body>
</html>