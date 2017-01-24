<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	
	<title>Εξέταση Διαγωνίσματος</title>
	
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
				<li><a href="${contextPath}/student">Επιστροφή</a></li>
			</ul>
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

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<c:if test="${empty loggedUser}">

		<c:redirect url="/login" />

	</c:if>

	<c:if test="${!empty loggedUser}">


		<div class="wrapper container" >
			<form:form action="${contextPath}/submitQuiz" commandName="quiz" class="form-inline"
				id="form">
               <form:input type="hidden" path="id" value="${id}"/>
               

				<c:forEach items="${quizList.questions}" varStatus="i">
					<div>
					<div id="question${i.index}">${i.index + 1}) ${quizList.questions[i.index].text}</div>
					
						<form:input type="hidden" path="questions[${i.index}].id" value="${quizList.questions[i.index].id}"/>
					
							<input type="checkbox" name="questions[${i.index}].answer[0].correct" value="true"> ${quizList.questions[i.index].answer[0].content}<br> 
							<form:input type="hidden" path="questions[${i.index}].answer[0].id" value="${quizList.questions[i.index].answer[0].id}"/>
							
							<input type="checkbox" name="questions[${i.index}].answer[1].correct" value="true"> ${quizList.questions[i.index].answer[1].content}<br> 
							<form:input type="hidden" path="questions[${i.index}].answer[1].id" value="${quizList.questions[i.index].answer[1].id}"/>
							
							<input type="checkbox" name="questions[${i.index}].answer[2].correct" value="true"> ${quizList.questions[i.index].answer[2].content}<br> 
							<form:input type="hidden" path="questions[${i.index}].answer[2].id" value="${quizList.questions[i.index].answer[2].id}"/>
							
							<input type="checkbox" name="questions[${i.index}].answer[3].correct" value="true"> ${quizList.questions[i.index].answer[3].content}<br> <br>
							<form:input type="hidden" path="questions[${i.index}].answer[3].id" value="${quizList.questions[i.index].answer[3].id}"/>
					</div>
				</c:forEach>
				
				<script type="text/javascript">
					$('input[type="checkbox"]').on('change', function() {
						
						$(this).siblings('input[type="checkbox"]').prop('checked', false);
						
					});
				</script>

				<button type="submit" class="btn btn-info">Υποβολή</button>
			</form:form>
		</div>
	</c:if>

	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>
			<center>
				Copyright &copy; QuizBomb 2017</font>
			</center>
			</p>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row --> </footer>
</body>
</html>