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
<title>Registration</title>
</head>
<body class="reg-bg">

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
	<div class=" card reg-box">
		<form:form method="post" action="/registration" modelAttribute="user">
			<div class="text-box">
				<form:input type="text" id="lastName" class="fadeIn second" name="firstName" placeholder="first name" path="firstName"/>
			</div>
	    	
	    	<div class="text-box">
	    		<form:input type="text" id="firstName" class="fadeIn second" name="lastName" placeholder="last name" path="lastName"/>
	    	</div>
	    	
	    	<div class="text-box">
	    		<form:input type="text" id="email" class="fadeIn second" name="email" placeholder="email" path="email"/>
	    	</div>
	    	
	    	<div class="text-box">
	    		<form:input type="password" id="password" class="fadeIn third" name="password" placeholder="password" path="password"/>
	    	</div>
	    	
	    	
	    	
	    	
	    	
	    	<form:input type="password" id="password" class="fadeIn third" name="password" placeholder="confirm password" path="pwConfirmation"/>
    	<input type="submit" class="fadeIn fourth" value="Register">
    </form:form>
     <div id="formFooter">
      <a class="underlineHover" href="/login">login</a>
    </div>
	</div>
    <!-- Registration Form -->


    <!-- back to login -->

  </div>
</div>


</body>
</html>