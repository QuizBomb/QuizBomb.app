<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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
	    <th width="70"> Question ID</th>
		<th width="200">Text</th>
		<th width="100">Answer1</th>
		<th width="100">Answer2</th>
		<th width="100">Answer3</th>
		<th width="100">Answer4</th>
		<th width="60">Delete</th>
		<th width="60">Accept</th>
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
                  <td style="color:red"><b>${question.answer[0].content}</b></td>
               </c:otherwise>
              </c:choose>

			 <c:choose>
                <c:when test="${question.answer[1].correct==true}">
                  <td style="color:green"><b>${question.answer[1].content}</b></td>
               </c:when>
			  <c:otherwise>
                  <td style="color:red"><b>${question.answer[1].content}</b></td>
               </c:otherwise>
              </c:choose>
              
              <c:choose>
                <c:when test="${question.answer[2].correct==true}">
                  <td style="color:green"><b>${question.answer[2].content}</b></td>
               </c:when>
			  <c:otherwise>
                  <td style="color:red"><b>${question.answer[2].content}</b></td>
               </c:otherwise>
              </c:choose>
              
              <c:choose>
                <c:when test="${question.answer[3].correct==true}">
                  <td style="color:green"><b>${question.answer[3].content}</b></td>
               </c:when>
			  <c:otherwise>
                  <td style="color:red"><b>${question.answer[3].content}</b></td>
               </c:otherwise>
              </c:choose>
           
			<td><input type="button"  onclick="location.href='questionRemove/${question.id}'" value="Remove Question" >
			<td><input type="button"  onclick="location.href='questionApprove/${question.id}'" value="Accept" >
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>