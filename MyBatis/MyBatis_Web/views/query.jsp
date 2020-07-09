<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--core-->
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>넘버</th>
		<th>아디</th>
		<th>비번</th>
	</tr>
	<c:forEach items="${list }" var="d">
		<tr>
		<!-- 자동으로 KEY값을 중심으로 사용할 수 있다 -->
			<td>${d.NO }</td>
			<td>${d.ID }</td>
			<td>${d.PW }</td>
	</tr>
	</c:forEach>
		
</table>	
</body>
</html>
