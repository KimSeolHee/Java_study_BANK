<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="container col-lg-8 mt-5">
	<div class="mb-3"><h3>상세보기 페이지</h3></div>
			<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">작성날짜</th>
	      <th scope="col">조회수</th>
	       <th scope="col">글내용</th>
	    </tr>
	  </thead>
	  <tbody>
	    	<tr>
				<td>${requestScope.detail.num}</td>
				<td>${detail.title}</td>
				<td>${detail.writer}</td>
				<td>${detail.regDate}</td>
				<td>${detail.hit}</td>
				<td>${detail.contents}</td>
	  	  </tr>
	</tbody>
	</table>
<br>
	<div class="mb-5">
		<c:if test="${not empty sessionScope.member}">
		<div>
			<a href="update.do?num=${requestScope.detail.num}"><b>글수정✍️</b></a>
			<a href="delete.do?num=${requestScope.detail.num}"><b>글삭제✂️</b></a>
		</div>
		</c:if>
		<br>
		</div>
	</div>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>