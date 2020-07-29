<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="query"/>
<button onclick="kakakoBookApi()">카카오 통신</button>
</body>
<script>
	function kakakoBookApi(){
		var query = document.querySelector("#query").value;
		var xhr = new XMLHttpRequest();
		xhr.open('GET','https://dapi.kakao.com/v3/search/book?query='+query);
		xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
		
		//인증키를 추가해서 기존보다 더 보내야된다
		xhr.setRequestHeader('Authorization', 'KakaoAK a98ab23d991c1afb2f613a9cfbf85378');
		//통신시작
		xhr.send();
		xhr.addEventListener('load', function() {
		 	//log보다 dir이 더 자세하다
			console.dir(xhr.response);
		});
	}
	
</script>
</html>
