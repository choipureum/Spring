<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>



</style>
</head>
<body>
<h1>부서입력</h1>
<hr>
	<form action="/dept/insert" method="post">
		<label>부서번호 : <input type="number" name="deptno" id="deptno"min="0" max="99" /></label><br>
		<label>부서이름 : <input type="text"name="dname" id="dname"/></label><br>
		<label>부서지역 : <input type="text"name="loc" id="loc"/></label><br>
		<button type="submit">제출</button>	
	</form>
</body>
</html>
