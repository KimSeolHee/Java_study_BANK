<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="mb-3"><h2>게시판🙋</h2></div>

	<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">작성날짜</th>
	      <th scope="col">조회수</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${list}" var="boardDTO">
	    <tr>
	      <td>${pageScope.boardDTO.num}</td>
		  <td><a href="detail.do?num=${boardDTO.getNum()}">${pageScope.boardDTO.title}</a></td>
		  <td>${pageScope.boardDTO.writer}</td>
		  <td>${pageScope.boardDTO.regDate}</td>
		  <td>${pageScope.boardDTO.hit}</td>
	    </tr>
	  </c:forEach>
	</tbody>
	</table>

	<div class="mt-3 mb-5">
	<c:if test="${not empty sessionScope.member}">
	<a href="add.do">글작성</a>
	 </c:if>
	<a href="../">홈으로</a>
	</div>
</div>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>