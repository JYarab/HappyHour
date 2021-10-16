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
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login Page</title>
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- HH Logo -->
    <div class="fadeIn first">
    	<img src="/images/alienPeace.png" id="icon" alt="User Icon" />
    </div>
    <div class="error_messages">
		<h3 class="text-success">${message}</h3>
    	<p><form:errors path="user.*"/></p>
    	<p><c:out value="${error}" /></p>
	</div>
	<div class=" card bg-dark login-box">
	    <!-- Login Form -->
	<form method="post" action="/login">
	<div class="text-box">
		<input type="text" id="email" class="fadeIn second" name="email" placeholder="login">
	</div>
    <div class="text-box">
         <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
    </div>

      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
        <!-- register -->
    <div id="formFooter">
      <a class="underlineHover" href="/register">Register New Account</a>
    </div>
	</div>




  </div>
</div>

</body>
</html>