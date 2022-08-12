<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 조회</h2>
	
	<form action="search.do" method="post">
		<input type="text" name="id" placeholder="조회할 ID를 입력하세요."><button>조회</button>
		<div><input type="reset"  value="재입력"></div>
	</form>
	<div>
		<a href="/">홈으로</a>
		<a href="./join.do">회원가입</a>
	</div>

</body>
</html>