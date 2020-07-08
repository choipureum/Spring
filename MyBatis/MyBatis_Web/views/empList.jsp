<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--core-->
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,th,td {border:1px solid black}
tbody>tr:hover{background:#DD0000}
</style>
</head>
<body>
<h1>사원 전체목록</h1>
<hr>
	<table>
	<thead>
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
	</thead>
	<tbody>
		<c:forEach items="${list }" var="list">
		<tr onclick="detailView(${list.empno})">
			<td>${list.empno }</td>
			<td>${list.ename }</td>	
			<td>${list.job }</td>		
			<td>${list.mgr }</td>				
			<td><fmt:formatDate value="${list.hiredate}" pattern="yyyy년MM월dd일" /></td>	
			<td>${list.sal }</td>
			<td>${list.comm }</td>
			<td>${list.deptno }</td>			
		</tr>		
	</c:forEach>	
	</tbody>
	</table>
</body>

<script>
function detailView(sw){
	location.href="/emp/detail?empno="+sw;	
}
</script>
</html>
