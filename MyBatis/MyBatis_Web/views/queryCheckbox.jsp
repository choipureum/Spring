<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>동적쿼리 테스트</h1>
	<hr>
	<form action="/dynamic/list" method="post">
		<label>10 부서<input type="checkbox" name="deptno" value="10"/></label><br>
		<label>20 부서<input type="checkbox" name="deptno" value="20"/></label><br>
		<label>30 부서<input type="checkbox" name="deptno" value="30"/></label><br>
		<button type="submit">전송</button>
	</form>




</body>
</html>
