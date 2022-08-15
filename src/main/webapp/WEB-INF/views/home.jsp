<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>My Bank Page</title>
</head>
<body>
<h1>
	My Bank Page 🙆‍♀️🙆‍♀️ 
</h1>
<c:if test="${empty sessionScope.member}">
<div>
	<a href = "./member/login.do"><b>로그인🔑</b></a>
</div>
<div>
	<a href = "./member/join.do"><b>회원가입✏</b></a>
</div>
</c:if>
<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.name} 님 환영합니다!</h3>
<div>
	<a href="./member/Logout.do"><b>로그아웃</b></a>
</div>
<div>
	<a href="#"><b>마이페이지</b></a>
</div>
</c:if>
<div>
	<a href = "./bankbook/list.do"><b>상품리스트📜</b></a>
</div>
<div>
	<a href = "./bankbook/add.do"><b>통장추가➕</b></a>
</div>
<div>
	<a href = "./member/search.do"><b>회원조회🔎</b></a>
</div>
<div>
	<a href = "./board/list.do"><b>게시판🚶‍♀️‍🏃‍♂️🤸</b></a>
</div>

</body>
</html>
