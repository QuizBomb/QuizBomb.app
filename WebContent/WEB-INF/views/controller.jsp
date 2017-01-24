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
	
	<title>Προβολή Ερωτήσεων</title>

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
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextPath}/">QuizBomb</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                
                 <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="${contextPath}/controller">Αρχική</a>
                    </li>
                    <li>
                        <a href="${contextPath}/statistics">Στατιστικά</a>
                    </li>
                </ul>
                 <ul class="nav navbar-nav navbar-right">
                
                	<li class="dropdown">
						<a href="" class="dropdown-toggle" data-toggle="dropdown"  aria-expanded="false"><i class="icon-star"></i> Καλωσήρθατε, ${loggedUser.fullName} <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
							<a href="${contextPath}/logout"><i class="icon-pencil fa-fw"></i> Αποσύνδεση</a>
							</li>
						</ul>
					</li>

				</ul>    
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	<c:if test="${empty loggedUser}">
	
		<c:redirect url="login"/>
	
	</c:if>
	
	<c:if test="${!empty loggedUser}">
	
		<div class="wrapper container">
		
			<c:if test="${empty questionsList}">
				<h4>Δεν υπάρχουν ερωτήσεις προς έγγκριση</h4>
			</c:if>
			
			<c:if test="${!empty questionsList}">
				<h4>Υπάρχουν οι εξής ερωτήσεις προς έγγκριση:</h4>
				<h6>*Οι σωστές απαντήσεις εμφανίζονται με πράσινο χρώμα</h6>
				<table class="tg">
				<tr>
				    <th width="10">Id</th>
					<th width="100">Ερώτηση</th>
					<th width="100">Απάντηση 1</th>
					<th width="100">Απάντηση 2</th>
					<th width="100">Απάντηση 3</th>
					<th width="100">Απάντηση 4</th>
					<th width="200">Ενέργειες</th>
				</tr>
				<c:forEach items="${questionsList}" var="question" >
					<tr>
						<td>${question.id}</td>
						<td>${question.text}</td>
						 <c:choose>
			                <c:when test="${question.answer[0].correct==true}">
			                  <td style="color:green"><b>${question.answer[0].content}</b></td>
			               </c:when>
						  <c:otherwise>
			                  <td>${question.answer[0].content}</td>
			               </c:otherwise>
			              </c:choose>
			
						 <c:choose>
			                <c:when test="${question.answer[1].correct==true}">
			                  <td style="color:green"><b>${question.answer[1].content}</b></td>
			               </c:when>
						  <c:otherwise>
			                  <td>${question.answer[1].content}</td>
			               </c:otherwise>
			              </c:choose>
			              
			              <c:choose>
			                <c:when test="${question.answer[2].correct==true}">
			                  <td style="color:green"><b>${question.answer[2].content}</b></td>
			               </c:when>
						  <c:otherwise>
			                  <td>${question.answer[2].content}</td>
			               </c:otherwise>
			              </c:choose>
			              
			              <c:choose>
			                <c:when test="${question.answer[3].correct==true}">
			                  <td style="color:green"><b>${question.answer[3].content}</b></td>
			               </c:when>
						  <c:otherwise>
			                  <td>${question.answer[3].content}</td>
			               </c:otherwise>
			              </c:choose>
			           	
			           	<td>
			           	
			           		<form style="display:inline;">
								<input type="button" class="btn btn-info" onclick="location.href='questionApprove/${question.id}'" value="Αποδοχή" >
								<input type="button" class="btn btn-danger" onclick="location.href='questionRemove/${question.id}'" value="Απόρριψη" >
							</form>
			           		
			           	</td>
						
					</tr>
				</c:forEach>
				</table>
			</c:if>
		
		</div>
	
	</c:if>
	
	<!-- Footer -->
    <footer>
    	<div class="row">
    		<div class="col-lg-12">
    			<p><center> Copyright &copy; QuizBomb 2017</font></center></p>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </footer>

</body>
</html>