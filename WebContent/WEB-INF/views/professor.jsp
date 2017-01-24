<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath }" />
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="shortcut icon" href="${contextPath}/resources/img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${contextPath}/resources/img/favicon.ico" type="image/x-icon">
	
	<title>Αρχική Σελίδα</title>

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
			
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="" class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false"><i
						class="icon-star"></i> Καλωσήρθατε, ${loggedUser.fullName} <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${contextPath}/logout"><i class="icon-pencil fa-fw"></i>
								Αποσύνδεση</a></li>
					</ul></li>

			</ul>
			<!-- /.navbar-collapse -->
		</div>
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="wrapper container">


		<c:if test="${empty loggedUser}">

			<c:redirect url="login" />

		</c:if>

		<c:if test="${!empty loggedUser}">
		
			<c:if test="${questionAddedSuccessfully}">
				<div class="alert alert-warning alert-dismissible" role="alert" >
		  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  			Η ερώτηση υποβλήθηκε προς έγγκριση.
				</div>
				 <c:remove var="questionAddedSuccessfully"/>
			</c:if>
					
			<h4>Επιλέξτε μία από τις παρακάτω ενέργειες.</h4>

			<button type="button" class="btn btn-info" aria-haspopup="true"
				aria-expanded="false" onclick="location.href='createQuestion'">
				Εισαγωγή Ερώτησης</button>

			<button type="button" class="btn btn-info" aria-haspopup="true"
				aria-expanded="false" onclick="location.href='createQuiz'">
				Δημιουργία Διαγωνίσματος</button>

		</c:if>

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