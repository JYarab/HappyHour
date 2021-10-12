<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/styleRegistration.css" rel="stylesheet" />
<title>Registration</title>
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="/images/alienPeace.png" id="icon" alt="User Icon" />
    </div>
    
    <div class="error_messages">
	<h3 class="text-success">${message}</h3>
    <p><form:errors path="user.*"/></p>
    <p><c:out value="${error}" /></p>
	</div>

    <!-- Registration Form -->
    <form:form method="post" action="/registration" modelAttribute="user">
    	<form:input type="text" id="lastName" class="fadeIn second" name="firstName" placeholder="first name" path="firstName"/>
    	<form:input type="text" id="firstName" class="fadeIn second" name="lastName" placeholder="last name" path="lastName"/>
    	<form:input type="text" id="email" class="fadeIn second" name="email" placeholder="email" path="email"/>
    	<form:input type="password" id="password" class="fadeIn third" name="password" placeholder="password" path="password"/>
    	<form:input type="password" id="password" class="fadeIn third" name="password" placeholder="confirm password" path="pwConfirmation"/>
    	<input type="submit" class="fadeIn fourth" value="Register">
    </form:form>

    <!-- back to login -->
    <div id="formFooter">
      <a class="underlineHover" href="/login">login</a>
    </div>
  </div>
</div>


</body>
</html>