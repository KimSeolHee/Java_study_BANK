<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>My Bank Page</title>
</head>
<body>
<h1>
	My Bank Page πββοΈπββοΈ 
</h1>
<h3>νμΈνλ €κ³  μ</h3>
<h3>νμΈνλ €κ³  μ2</h3>
<c:if test="${empty sessionScope.member}">
<div>
	<a href = "./member/login.do"><b>λ‘κ·ΈμΈπ</b></a>
</div>
<div>
	<a href = "./member/join.do"><b>νμκ°μβ</b></a>
</div>
</c:if>
<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.name}λ νμν©λλ€!</h3>
<div>
	<a href="./member/Logout.do"><b>λ‘κ·Έμμ</b></a>
</div>
<div>
	<a href="#"><b>λ§μ΄νμ΄μ§</b></a>
</div>
</c:if>
<div>
	<a href = "./bankbook/list.do"><b>μνλ¦¬μ€νΈπ</b></a>
</div>
<div>
	<a href = "./bankbook/add.do"><b>ν΅μ₯μΆκ°β</b></a>
</div>
<div>
	<a href = "./member/search.do"><b>νμμ‘°νπ</b></a>
</div>
<div>
	<a href = "./board/list.do"><b>κ²μνπΆββοΈβπββοΈπ€Έ</b></a>
</div>

</body>
</html>
