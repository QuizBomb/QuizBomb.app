<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="shortcut icon" href="${contextPath}/resources/img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${contextPath}/resources/img/favicon.ico" type="image/x-icon">
	
	<title>Εγγραφή</title>

	<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/style.css">

	<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
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


			<a class="navbar-brand" href="${contextPath}/">QuizBomb</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${contextPath}/login">Είσοδος</a></li>
				<li class="active"><a href="${contextPath}/register">Εγγραφή</a></li>
			</ul>
			
		</div>
	</div>
	</nav>

	<div class="wrapper">

		<div class="container">
			<div class="row">
				<div class="form-box">
					<h1>
						Φόρμα Εγγραφής
					</h1>
					
					<ul class="nav nav-tabs">
						 <li role="presentation" class="active"><a>Μαθητής</a></li>
						 <li role="presentation" class="disabled"><a>Καθηγητής</a></li>
					</ul>
					<br>
					<form:form action="performRegistration" commandName="student"
						class="form-inline form-group">
						
						
						<div class="form-group">
							<label>Ονοματεπώνυμο:</label>
							<form:input path="fullName" type="text" class="form-control" placeholder="Εισάγετε το ονοματεπώνυμό σας"/>
						</div>

						<p>
						<br>
						
						<div class="form-group">
							<label>Username:</label>
							<form:input path="username" type="text" class="form-control" placeholder="Εισάγετε το username σας"/>
						</div>

						<p>
						<br>
						
						<div class="form-group">
							<label>Password:</label>
							<form:input path="password" type="password" class="form-control" placeholder="Εισάγετε το password σας"/>
						</div>

						<p>
						<br>
						
						<div class="form-group">
							<label>Email:</label>
							<form:input path="email" type="text" class="form-control" placeholder="Εισάγετε το email σας"/>
						</div>

						<p>
						<br>
						
						<div class="form-group">
							<label>Τάξη:</label>
							<form:select path="sClassId">
							   <option value="1">Α' Γυμνασίου</option>
							   <option value="2">Β' Γυμνασίου</option>
							   <option value="3">Γ' Γυμνασίου</option>
							</form:select>
						</div>
						
						<p>
						<br>
						
						<button type="submit" class="btn btn-info">Εγγραφή</button>
						
					</form:form>


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