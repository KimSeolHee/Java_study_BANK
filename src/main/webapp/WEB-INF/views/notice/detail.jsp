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
	<section class="container col-la-8">
		<div class="mt-5 mb-3"><h2>상세보기🔎</h2></div>	
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">num</th>
					<th scope="col">title</th>
					<th scope="col">contents</th>
					<th scope="col">writer</th>
					<th scope="col">regDate</th>
					<th scope="col">hit</th>
				</tr>
			</thead>
			<tbody>
				<td>${requestScope.boardDTO.num}</td>
				<td>${requestScope.boardDTO.title}</td>
				<td>${requestScope.boardDTO.contents}</td>
				<td>${requestScope.boardDTO.writer}</td>
				<td>${requestScope.boardDTO.regDate}</td>
				<td>${requestScope.boardDTO.hit}</td>
			</tbody>
		</table>
			<div>
				<a href="./list.do"><b>글목록📑</b></a>
					<c:if test="${sessionScope.member.id eq requestScope.boardDTO.writer}" >
					<a href="./update.do?num=${boardDTO.num}"><b>글수정✒</b></a>
					<a href="./delete.do?num=${boardDTO.num}"><b>글삭제❌</b></a>
					</c:if>
			</div>
	</section>
	<br>

<c:import url="../template/footer.jsp"></c:import>
</body>
</html>