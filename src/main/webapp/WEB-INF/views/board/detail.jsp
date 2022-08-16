<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상세보기 페이지</h3>
<table border="2">
	<thead>
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성날짜</td><td>조회수</td><td>글내용</td>
	</tr>
	</thead>
	<tbody>
			<tr>
				<td>${requestScope.detail.boardNum}</td>
				<td>${detail.title}</td>
				<td>${detail.writer}</td>
				<td>${detail.writeDate}</td>
				<td>${detail.hits}</td>
				<td>${detail.content}</td>
			</tr>
	</tbody>
</table>
<hr>
	<c:if test="${not empty sessionScope.member}">
	<div>
		<a href="update.do?boardNum=${detail.boardNum}"><b>글수정✍️</b></a>
		<a href="delete.do?boardNum=${detail.boardNum}"><b>글삭제✂️</b></a>
	</div>
	</c:if>
</body>
</html>