<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  

  <div class="container">
  
  	
  	<c:if test="${failedLogin == true}">
  	
  	 <p style="color:red"> Login Failed. Please try again. </p>
  	
  	</c:if>
    
    
    <form:form action="performLogin" commandName="user" class="form-inline">
   	<label><b>Username</b></label>
    <form:input path="username" type="text" placeholder="Enter Username"/>

    <label><b>Password</b></label>
    <form:input path="password" type="password" placeholder="Enter Password"/>

    <button type="submit">Login</button>
   	
   																			<!-- <input type="checkbox" checked="checked"> Remember me-->
 	</form:form>
 
  </div>

  <div class="container" style="background-color:#f1f1f1">

  </div>

</body>
</html>