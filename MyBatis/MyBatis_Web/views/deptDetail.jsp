<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td{
		all:unset; 
		border:1px solid black; 
		border-collapse:collapse;
		}
</style>
</head>
<body>
<h1>${dept.dname }의 상세정보</h1>
<hr>
<table>
	<tr>
		<td>${dept.deptno }</td>
		<td>${dept.dname }</td>
		<td>${dept.loc }</td>
	</tr>
</table>
<br>
</body>
</html>
