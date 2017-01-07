<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
	Questions
</h1>

<br>
<h3>Question List</h3>
<c:if test="${empty questionsList}">
<p>page is empty</p>
</c:if>
<c:if test="${!empty questionsList}">
	<table class="tg">
	<tr>
	    <th width="80"> Question ID</th>
		<th width="120">Text</th>
	</tr>
	<c:forEach items="${questionsList}" var="question">
		<tr>
			<td><form><input type="checkbox" name="quest" value="quest" id="quest"></form></td>
			<td>${question.text}</td>
			<td>${question.answer}</td>				
			<td><input type="button"  onclick="location.href='questionRemove/${question.id}'" value="Remove Question" >
			<td><input type="button"  onclick="location.href='questionApprove/${question.id}'" value="Accept" >
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>