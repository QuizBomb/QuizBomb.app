<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Εισαγωγή Ερώτησης</title>

<link rel="stylesheet" href="resources/css/style.css">

<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<c:if test="${empty loggedUser}">
	
		<c:redirect url="login"/>
	
	</c:if>
	
	<c:if test="${!empty loggedUser}">
		<h3> Καλωσήρθατε, ${loggedUser.fullName}</h3>
		
		<div class="jumbotron">
			<h4>Συμπληρώστε τη νέα ερώτηση:</h4>
			
			<form:form action="addQuestion" commandName="question" class="form-inline">
			
				<div class="form-group">
					<label>Ερώτηση:</label>
					<form:textarea rows="3" cols="30" path="text" type="text" class="form-control" placeholder="Εισάγετε την ερώτηση"/>
				</div>
				<br>
				<div class="form-group">
					<select onchange="setCourseId();" id="classCourse">
						<option value="0 | 0" selected>Επιλέξτε το Μάθημα</option>
					    <c:forEach items="${loggedUser.classCourse}" var="classCourse">
					        <option value="${classCourse.course.id}|${classCourse.sClass.id} " >${classCourse.course.name} (${classCourse.sClass.value})</option>
					    </c:forEach>
					</select>
					
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
				</div>	
				
				<br>
				
				<div class="form-group">
					<label>Απάντηση 1:</label>
					<form:input path="answer[0].content" type="text" class="form-control" placeholder="Εισάγετε την πρώτη επιλογή"/>
					<input type="checkbox" name="answer[0].correct" class="form-control" value="true"/>
				</div>
				<div class="form-group">
					<label>Απάντηση 2:</label>
					<form:input path="answer[1].content" type="text" class="form-control" placeholder="Εισάγετε την δεύυτερη επιλογή"/>
					<input type="checkbox" name="answer[1].correct" class="form-control" value="true"/>
				</div>
				<div class="form-group">
					<label>Απάντηση 3:</label>
					<form:input path="answer[2].content" type="text" class="form-control" placeholder="Εισάγετε την τρίτη επιλογή"/>
					<input type="checkbox" name="answer[2].correct" class="form-control" value="true"/>
				</div>
				<div class="form-group">
					<label>Απάντηση 4:</label>
					<form:input path="answer[3].content" type="text" class="form-control" placeholder="Εισάγετε την τέταρτη επιλογή"/>
					<input type="checkbox" name="answer[3].correct" class="form-control" value="true"/>
				</div>
				
				<script type="text/javascript">
					$('input[type="checkbox"]').on('change', function() {
						 $('input[type="checkbox"]').not(this).prop('checked', false);
					});
				</script>
				 
				<br>
				<br>
				<button type="submit" class="btn btn-default">Καταχώρηση</button>
			</form:form>
		</div>
		
	</c:if>
</body>
</html>