<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>수정Page</h2>
	
	<form action="update.do" method="POST">
		<div>
		<input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
		<span><b>제목 : </b></span><input readonly type="text" name="title" value="${boardDTO.title}">
		</div>
		<div>
		<span><b>내용 : </b></span><input type="text" name="content" value="${boardDTO.content}">
		</div>
		<input type="submit" value="수정하기">
		<a href="update.do?boardNum=${boardDTO.getBoardNum()}"></a>
	</form>
</body>
</html>