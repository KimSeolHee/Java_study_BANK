<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container col-lg-6">
		<div class="mt-5 mb-3"><h2 style="text-align:center;">${board} 상세보기🔎</h2></div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">작성자</th>
					<th scope="col">입력날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<td>${requestScope.boardDTO.num}</td>
				<td>${requestScope.boardDTO.writer}</td>
				<td>${requestScope.boardDTO.regDate}</td>
				<td>${requestScope.boardDTO.hit}</td>
			</tbody>
		</table>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label"><b>제목</b></label>
			<input type="text" readonly class="form-control" id="exampleFormControlInput1" value="${requestScope.boardDTO.title}">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label"><b>내용</b></label>
			<textarea class="form-control" readonly id="exampleFormControlTextarea1" rows="5">${requestScope.boardDTO.contents}</textarea>
		</div>
		
		<div><h5>파일</h5>
		<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			<p><a href="../resources/upload/${board}/${fileDTO.fileName}">${fileDTO.oriName}</a></p>
		</c:forEach>
		</div>
		
		
		<div  style="text-align:right;">
			<br>
			<c:if test="${not empty sessionScope.member}">
			<a href="reply.do?num=${boardDTO.num}" class="mb-3 btn btn-dark" >답글달기</a>
			</c:if>
			<button class="btn btn-dark mb-3 text-white"><a href="./list.do" style="text-decoration:none; color: white;">글목록📑</a></button>
					<c:if test="${sessionScope.member.id eq requestScope.boardDTO.writer}" >
					<button class="btn btn-dark mb-3 text-white"><a href="./update.do?num=${boardDTO.num}" style="text-decoration:none; color: white;">글수정✒</a></button>
					<button class="btn btn-dark mb-3 text-white"><a href="./delete.do?num=${boardDTO.num}" style="text-decoration:none; color: white;">글삭제❌</a></button>
					</c:if>
			</div>
			<br>
	</section>
	<br>

<c:import url="../template/footer.jsp"></c:import>
</body>
</html>