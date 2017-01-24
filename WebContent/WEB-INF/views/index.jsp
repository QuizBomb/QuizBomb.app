<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<title>QuizBomb</title>

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
				<li><a href="${contextPath}/register">Εγγραφή</a></li>
			</ul>
			
		</div>
	</div>
	</nav>
	
	<div class="wrapper">
		<div class="welcome">

			<div class="container">
					<div class="col-md-12">

						<h1>
							<i>"Η ευτυχια του ανθρωπου <p> συνισταται στη μορφωση και στη παιδεια <p> και οχι στα αγαθα που δινει και παιρνει η τυχη!"</p>
						 <p><small>Πλουταρχος</small></p>
						 </i>
						</h1>
						<hr
							style="width: 25%; text-align: left; margin: 30px 0; border: 2.5px solid #fff;" />
					</div>
					<div class="col-md-8">
						<b><h2 class="subtitle"> ~ Καλη αρχη ~ </h2>
					</b>
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