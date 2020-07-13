<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td{border:1px solid black}

</style>
</head>
<body>
<h1>
사원 세부정보
</h1>
<hr>
	<table>
		<c:forEach items="${list }" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.deptno }</td>
			</tr>		
			</c:forEach>
		</table>
	
	
</body>
</html>
