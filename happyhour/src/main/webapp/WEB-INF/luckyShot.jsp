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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a66dc40b69.js" crossorigin="anonymous"></script>
<title>Luck Drink</title>
</head>
<body style="background-color:grey;">
	<h1 style="text-align: center;">Random Drinks</h1>
	<div class="flex-container">
	<c:forEach items="${drinks}" var="drink">
  	<div class="card" style="width: 30rem;display:inline-flex;">
    
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