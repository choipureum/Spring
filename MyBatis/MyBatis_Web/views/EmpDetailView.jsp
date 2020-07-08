<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,th,td {border:1px solid black;font-size:30px}
</style>
</head>
<body>
	<h1>${list.ename } 상세정보</h1>
	<hr>
	<table>
	<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>직업</th>
			<th>mgr</th>
			<th>입사일</th>
			<th>sal</th>
			<th>comm</th>
			<th>부서번호</th>
		</tr>
		<tr >
			<td>${list.empno }</td>
			<td>${list.ename }</td>	
			<td>${list.job }</td>		
			<td>${list.mgr }</td>	
			<td><fmt:formatDate value="${list.hiredate}" pattern="yyyy년MM월dd일" /></td>	
			<td>${list.sal }</td>
			<td>${list.comm }</td>
			<td>${list.deptno }</td>			
		</tr>	
	</table>
	<br>
	<button onclick="location.href='/emp/list'">뒤로가기</button>	
</body>
</html>








