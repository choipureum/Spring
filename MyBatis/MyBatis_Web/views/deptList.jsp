<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
tbody>tr:hover{background:#DD0000}
table,td,th {
	border:1px solid black;
	border-collapse:collapse; 
	/*separate 속성=2줄*/
}
button:hover{background-color:pink; transition:1s}
button{all:unset; border:2px solid pink; background-color:#eee;
border-radius:50px;
width:80px;height:80px;text-align:center;}
</style>
<body>
	<h1>부서정보 목록</h1>
	<hr>
	<table>
		<thead>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>위치</th>
		</tr>
		</thead>
		<c:forEach items="${deptList }" var="d">
			<tr onclick="detailView(${d.deptno})">
				<td>${d.deptno }</td>
				<td>${d.dname }</td>
				<td>${d.loc }</td>
			</tr>		
		</c:forEach>
	</table>
	<br>
	<button onclick='insertDept()'>부서삽입</button>
</body>
<script>

function detailView(sw){
	location.href="/dept/detail?deptno="+sw;	
}
function insertDept(){
	location.href="/dept/insert";	
}
</script>
</html>
