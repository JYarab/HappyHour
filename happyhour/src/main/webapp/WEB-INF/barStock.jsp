<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSP functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>${user.firstName}'s Bar</title>
</head>
<body>
	<div class="container">
	<h4>There are ${fn:length(allDrinks)} Drinks in the Database.</h4>
	<h4>Here's what you can make!</h4>
<!-- Search Results Go Here -->		
	<div class="container">
		<div class="row g-3">
			<c:forEach items="${allDrinks}" var="drink">	
				<c:if test="${pantry.containsAll(drink.getIngredientList())}">						
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
				</c:if>							
			</c:forEach>
		</div>
		
	</div>	
	
	</div>
</body>
</html>