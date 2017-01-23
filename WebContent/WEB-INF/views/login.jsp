<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<title>QuizBomb -> Είσοδος </title>

	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/style.css">

	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>

  <!-- Navigation -->

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>


			<a class="navbar-brand" href="#">QuizBomb</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="login">Είσοδος</a></li>
				<li><a href="register">Εγγραφή</a></li>
			</ul>
			
		</div>
	</div>
	</nav>
  
  	<div class="wrapper">
  	
  		<div class="container">
  	
	  		<c:if test="${failedLogin == true}">
	  	
		  	 <p style="color:red"> Login Failed. Please try again. </p>
		  	
		  	</c:if>
		    
		    
		    <form:form action="performLogin" commandName="user" class="form-inline">
		   	
		    
		    <div class="form-group">
					<label>Username:</label>
					<form:input path="username" type="text" class="form-control" placeholder="Εισάγετε το όνομα χρήστη"/>
				</div>
				<p>
				<br>
				<div class="form-group">
					<label>Password:</label>
					<form:input path="password" type="password" class="form-control" placeholder="Εισάγετε τον κωδικό πρόσβασης"/>
				</div>
				</p>
			<br>
		    <button class="btn btn-info" type="submit">Σύνδεση</button>
		   	
		   																			<!-- <input type="checkbox" checked="checked"> Remember me-->
		 	</form:form>
		 	
		 </div>
	  	
			<div class="login">
			
				<div class="container">
	
						<div class="col-md-12">			
							<hr style="width: 25%; text-align: left; margin: 30px 0; border: 2.5px solid #fff;" />
						</div>
						
					</div>
			
		</div>
		
	</div>
  
  <!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>
				<center>Copyright &copy; QuizBomb 2017</center>
				</center>
				</p>
			</div>
			<!-- /.col-lg-12 -->
		</div>
	<!-- /.row --> 
	</footer>

</body>
</html>