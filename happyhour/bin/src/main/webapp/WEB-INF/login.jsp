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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
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
    <div style="text-align: center; margin-top: 8%;">
    <img src="/image/hh.png" alt="Happy Hour" width="200" height="200">
	</div>
	
	<div class=" card  login-box">
	    <!-- Login Form -->
	<form method="post" action="/login">
	    <div class="input-group mb-3 ">
	    	<span class="input-group-text" id="basic-addon1"><i class="fas fa-user"></i></span>
		  	<input type="text" class="form-control" name="email" placeholder="Username" >
		</div>
		
		<div class="input-group mb-3 ">
	    	<span class="input-group-text" id="basic-addon1"><i class="fas fa-lock"></i></span>
		  	<input type="password" class="form-control"  name="password" placeholder="Password">
		</div>
	
	      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
        <!-- register -->
    <div id="formFooter">
      <a class="underlineHover" href="/register">Register New Account</a>
    </div>
    <p class="error"><c:out value="${error}" /></p>
	</div>




  </div>
</div>

</body>
</html>