<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Δημιουργία Διαγωνίσματος</title>

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
			<h4>Δημιουργήστε ένα νέο διαγώνισμα:</h4>
			
			<form:form action="${pageContext.request.contextPath}/addQuiz" commandName="quiz2" class="form-inline">
	
				<br>
				<div class="form-group">
					<select onchange="setCourseId();" id="classCourse">
						<option value="0 | 0" selected>Επιλέξτε το Μάθημα</option>
					    <c:forEach items="${loggedUser.classCourse}" var="classCourse">
					        <option value="${classCourse.course.id}|${classCourse.sClass.id} " >${classCourse.course.name} (${classCourse.sClass.value})</option>
					    </c:forEach>
					</select>
					
					<input type="hidden" name="sClassId" id="sClass" value="${sClassId}"/>
					
					<input type="hidden" name="courseId" id="course" value="${courseId}"/>
					
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
				<div class="form-froup">
					
				    				    
					<a href='' onclick="href='${pageContext.request.contextPath}/createQuiz/loadQuestions/'+document.getElementById('sClass').value+'/'+document.getElementById('course').value">Φόρτωση Ερωτήσεων</a>
				    
				</div>
				<br>
				<br>
				
				<c:if test="${!empty quiz2.questions}">
					<div class="form-group">	
						
						<div class="form-group">
							<label>Τίτλος:</label>
							<form:input path="title" type="text" class="form-control" placeholder="Εισάγετε τίτλο"/>
						</div>
						
						<table>
							<c:forEach items="${quiz2.questions}" varStatus="i">
								<tr>
								
									<td><input type="checkbox" name="questions[${i.index}].selected" class="form-control" value="true"/></td>
									<td><form:input type="hidden" path="questions[${i.index}].id" value="${questions[i.index].id}"/></td>
									<td><form:input type="text" path="questions[${i.index}].text" value="${questions[i.index].text}" disabled=""/></td>
								</tr>	
								
							</c:forEach>
						</table>
						
				      
						
					</div>
					
					<br>
					<button type="submit" class="btn btn-default">Καταχώρηση</button>
					
				</c:if>
			</form:form>
		</div>
		
	</c:if>
</body>
</html>