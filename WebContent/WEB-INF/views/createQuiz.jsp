<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" scope="request" value="${pageContext.request.contextPath }" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Δημιουργία Διαγωνίσματος</title>

	<!--  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>"> -->
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
		
		<c:redirect url="/login"/>
		
	</c:if>
		
	<c:if test="${!empty loggedUser}">
		
	   <div class="wrapper container-fluid">
      	  <div class="row">
			
			<div class="col-md-10 col-md-push-1">
				<h4>Δημιουργήστε ένα νέο διαγώνισμα:</h4>
				
				<form:form action="${contextPath}/addQuiz" commandName="quiz2" class="form-inline">
		
					<br>
					<div class="form-group">
						<select onchange="setCourseId();" id="classCourse" class="form-control">
							<option value="0 | 0" selected>Επιλέξτε το Μάθημα</option>
						    <c:forEach items="${loggedUser.classCourse}" var="classCourse">
						        <option value="${classCourse.course.id}|${classCourse.sClass.id} " >${classCourse.course.name} (${classCourse.sClass.value})</option>
						    </c:forEach>
						</select>
						
						<input type="hidden" name="sClassId" id="sClass" value="${sClassId}"/>
						
						<input type="hidden" name="courseId" id="course" value="${courseId}"/>
						
					</div>	
					
					<br>
					<div class="form-group" style="margin-top:1cm;">
								    
						<a href='' onclick="href='${contextPath}/createQuiz/loadQuestions/'+document.getElementById('sClass').value+'/'+document.getElementById('course').value" id="linkLQ" class="btn btn-primary">Φόρτωση Ερωτήσεων</a>
					    
					</div>
					<br>
					
					<c:if test="${!empty quiz2.questions}">
						<div style="margin-top:70px">	
							
							<div class="form-group">
								<label>Τίτλος:</label>
								<form:input path="title" type="text" class="form-control" style="width:300px;" placeholder="Εισάγετε τίτλο"/>
							</div>
							<br>
							<div style="margin-top:50px; margin-bottom:40px;">
								<h4>Επιλογή Ερωτήσεων</h4>
							</div>
							
							<div class="form-group">
								<table class="table table-striped table-bordered">
									<tr>
									    <th width="20"> </th>
										<th width="200">Ερώτηση</th>
										<th width="150">1η Απάντηση</th>
										<th width="150">2η Απάντηση</th>
										<th width="150">3η Απάντηση</th>
										<th width="150">4η Απάντηση</th>
									</tr>
									<c:forEach items="${quiz2.questions}" varStatus="i">
										<tr>
											<td><input type="checkbox" name="questions[${i.index}].selected" value="true"/></td>
											<form:input type="hidden" path="questions[${i.index}].id" value="${questions[i.index].id}"/>
											<td><form:input type="text" path="questions[${i.index}].text" value="${questions[i.index].text}" disabled="true" style="border:none; background-color:transparent;"/></td>
										    <c:forEach begin="0" end="3" varStatus="val">
												<c:choose>
			                						<c:when test="${quiz.questions[i.index].answer[val.index].correct==true}">
			                  							<td style="color:green"><b>${quiz.questions[i.index].answer[val.index].content}</b></td>
			               							</c:when>
						  							<c:otherwise>
			                  							<td>${quiz.questions[i.index].answer[val.index].content}</td>
			               							</c:otherwise>
			              						</c:choose>
		              						</c:forEach>
										</tr>	
									</c:forEach>
								</table>
							 </div>
						     <br>
						     <button type="submit" class="btn btn-success">Καταχώρηση</button>
					     </div>
					  </c:if>
				 </form:form>
			 </div>
		   </div>
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

	<script type="text/javascript">
		  
	 	$(document).ready(function (e) {
	 		
	 		$('#linkLQ').click(function (e) {
				if ($("#classCourse").prop('selectedIndex') == 0) {	
				  e.preventDefault();
				  alert("Επιλέξτε μάθημα");
				  $('#linkLQ').blur();
				} 
				
			});
	 	});
	
	
	   	function setCourseId(){
			 var selectBox = document.getElementById("classCourse");
			 var selectedValue = selectBox.options[selectBox.selectedIndex].value;
			 var values = selectBox.options[selectBox.selectedIndex].value.split('|');
	
			 document.getElementById("sClass").value= values[1];
			 document.getElementById("course").value= values[0];
		}
		
	</script>
</body>
</html>