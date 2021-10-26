<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
    <!-- HH Logo -->
    <div style="text-align: center; margin-top: 3%;">
    <img src="/image/logo1.png" alt="Happy Hour" width="200" height="200">
	</div>

	<div class="card reg-box mt-4">
		<form:form method="post" action="/registration" modelAttribute="user">
			<div class="text-box mb-3">
				<form:input type="text" id="lastName" class="form-group" name="firstName" placeholder="first name" path="firstName"/>
			</div>
	    	
	    	<div class="text-box mb-3"">
	    		<form:input type="text" id="firstName" class="form-group" name="lastName" placeholder="last name" path="lastName"/>
	    	</div>
	    	
	    	<div class="text-box mb-3"">
	    		<form:input type="text" id="email" class="form-group" name="email" placeholder="email" path="email"/>
	    	</div>
	    	
	    	<div class="text-box mb-3"">
	    		<form:input type="password" id="password" class="form-group" name="password" placeholder="password" path="password"/>
	    	</div>
	    	<div class="text-box mb-3"">
	    		<form:input type="password" id="password" class="fadeIn third" name="password" placeholder="confirm password" path="pwConfirmation"/>
	    	</div>	
    	<input type="submit" class="btn btn-primary" value="Register">
    </form:form>
     <div id="formFooter">
      <a class="underlineHover" href="/login">login</a>
    </div>
    <p><form:errors path="user.*"/></p>
	</div>
    <!-- Registration Form -->


    <!-- back to login -->

  </div>
</div>


</body>
</html>