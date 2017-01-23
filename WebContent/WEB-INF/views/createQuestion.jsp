<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<title>Εισαγωγή Ερώτησης</title>

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
                    <li>
                        <a href="${contextPath}/professor">Επιστροφή</a>
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
			<h4>Συμπληρώστε τη νέα ερώτηση:</h4>
			
			<form:form action="addQuestion" commandName="question" class="form-inline" id="form">
				
				<br>
				<div class="form-group">
					<select onchange="setCourseId();" id="classCourse" name="classCourse">
						<option value="0 | 0" selected>Επιλέξτε το Μάθημα</option>
					    <c:forEach items="${loggedUser.classCourse}" var="classCourse">
					        <option value="${classCourse.course.id}|${classCourse.sClass.id} " >${classCourse.course.name} (${classCourse.sClass.value})</option>
					    </c:forEach>
					</select>
				</div>
				
				<br>
				<br>
				<div class="form-group">
					<label>Ερώτηση:</label>
					<form:textarea rows="3" cols="30" path="text" type="text" class="form-control" placeholder="Εισάγετε την ερώτηση" name="text"/>
				</div>
				<br>
					
				<input type="hidden" name="sClassId" id="sClass"/>
					
				<input type="hidden" name="courseId" id="course"/>
					
				<script type="text/javascript">
					function setCourseId(){
						 var selectBox = document.getElementById("classCourse");
						 var selectedValue = selectBox.options[selectBox.selectedIndex].value;
						 var values = selectBox.options[selectBox.selectedIndex].value.split('|');

						 document.getElementById("sClass").value= values[1];
						 document.getElementById("course").value= values[0];
					}
				</script>
			
				<br>
				<div class="form-group">
					<label>Απάντηση 1:</label>
					<form:input path="answer[0].content" type="text" class="form-control" placeholder="Εισάγετε την πρώτη επιλογή" id="answer1"/>
					Σωστή: <input type="checkbox" name="answer[0].correct" class="form-control" value="true"/>
				</div>
				
				<br>
				<div class="form-group">
					<label>Απάντηση 2:</label>
					<form:input path="answer[1].content" type="text" class="form-control" placeholder="Εισάγετε την δεύυτερη επιλογή" id="answer2"/>
					Σωστή: <input type="checkbox" name="answer[1].correct" class="form-control" value="true"/>
				</div>
				
				<br>
				<div class="form-group">
					<label>Απάντηση 3:</label>
					<form:input path="answer[2].content" type="text" class="form-control" placeholder="Εισάγετε την τρίτη επιλογή" id="answer3"/>
					Σωστή: <input type="checkbox" name="answer[2].correct" class="form-control" value="true"/>
				</div>
				
				<br>
				<div class="form-group">
					<label>Απάντηση 4:</label>
					<form:input path="answer[3].content" type="text" class="form-control" placeholder="Εισάγετε την τέταρτη επιλογή" id="answer4"/>
					Σωστή: <input type="checkbox" name="answer[3].correct" class="form-control" value="true"/>
				</div>
				
				<script type="text/javascript">
					$('input[type="checkbox"]').on('change', function() {
						 $('input[type="checkbox"]').not(this).prop('checked', false);
					});
				</script>
				 
				<br>
				<br>
				
				
				<button type="button" class="btn btn-info" id="submitButton">Καταχώρηση</button>
				<script type="text/javascript">
				
					var checkboxes = document.querySelectorAll('input[type="checkbox"]');
					
					$('#submitButton').click(function(){
						
					 	if (classCourse.value === "0 | 0")
					 		alert("Επιλέξτε ένα μάθημα");
					 	else if (text.value === "")
					 		alert("Σημπληρώστε την ερώτηση");
					 	else if (document.getElementById('answer1').value === "")
					 		alert("Σημπληρώστε την πρώτη απάντηση");
					 	else if (document.getElementById('answer2').value === "")
					 		alert("Σημπληρώστε τη δεύτερη απάντηση");
					 	else if (document.getElementById('answer3').value === "")
					 		alert("Σημπληρώστε τη τρίτη απάντηση");
					 	else if (document.getElementById('answer4').value === "")
					 		alert("Σημπληρώστε τη τέταρτη απάντηση");
					 	else if (Array.prototype.slice.call(checkboxes).some(x => x.checked) == false)
					 		alert("Πρέπει να επιλέξετε μία σωστή απάντηση");
					 	else
					 		document.getElementById('form').submit();

					});
				</script>
			</form:form>
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