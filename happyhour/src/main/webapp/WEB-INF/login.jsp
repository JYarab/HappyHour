<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
    <div class="error_messages">
		<h3 class="text-success">${message}</h3>
    	<p><form:errors path="user.*"/></p>
    	<p><c:out value="${error}" /></p>
	</div>
	<div class=" card  login-box">
	    <!-- Login Form -->
	<form method="post" action="/login">
	
	
	<div class="text-box input-group">
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