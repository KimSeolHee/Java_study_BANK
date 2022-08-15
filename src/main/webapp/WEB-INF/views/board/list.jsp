<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판🙋</h2>
<table border="2">
	<thead>
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성날짜</td><td>조회수</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="boardDTO">
			<tr>
				<td>${pageScope.boardDTO.boardNum}</td>
				<td><a href="detail.do?boardNum=${boardDTO.getBoardNum()}">${pageScope.boardDTO.title}</a></td>
				<td>${pageScope.boardDTO.writer}</td>
				<td>${pageScope.boardDTO.writeDate}</td>
				<td>${pageScope.boardDTO.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
<c:if test="${not empty sessionScope.member}">
<a href="add.do">글작성</a>
 </c:if>
</div>
<a href="../">홈으로</a>
</body>
</html>