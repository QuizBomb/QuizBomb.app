<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Αρχική Σελίδα</title>
</head>
<body>
	<c:if test="${empty loggedUser}">
	
		<c:redirect url="login"/>
	
	</c:if>
	
	<c:if test="${!empty loggedUser}">
		<h3> Καλωσήρθατε, ${loggedUser.fullName}</h3>
		<h4>Επιλέξτε μία από τις παρακάτω ενέργειες.</h4>
		
		<input type="button"  onclick="location.href='createQuestion'" value="Εισαγωγή Ερώτησης" >
		<input type="button"  onclick="location.href=''" value="Δημιουργία Διαγωνίσματος" >
	</c:if>
</body>
</html>