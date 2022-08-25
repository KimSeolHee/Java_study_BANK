<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
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
	<section class="container col-lg-8" style="text-align:center;">
	<div class="mt-5 mb-3"><h2><b>${requestScope.board}</b></h2></div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>입력일자</th><th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="BoardDTO">
					<tr>
						<td>${pageScope.BoardDTO.num}</td>
						<td><a href="./detail.do?num=${BoardDTO.getNum()}">${pageScope.BoardDTO.title}</a></td>
						<td>${pageScope.BoardDTO.writer}</td>
						<td>${pageScope.BoardDTO.regDate}</td>
						<td>${pageScope.BoardDTO.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			<nav aria-label="Page navigation example"">
  <ul class="pagination" style="justify-content: center;">
    <li class="page-item">
    <c:if test="${pager.startNum != 1}">
      <a class="page-link" href="./list.do?page=${pager.startNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
      </c:if>
    </li>
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    	<li class="page-item"><a class="page-link" href="./list.do?page=${pageScope.i}">${pageScope.i}</a></li>
    </c:forEach>
<%--  <c:choose>
 <c:when test="${pager.next}">
    <li class="page-item">
 </c:when>
 <c:otherwise>
     <li class="page-item disabled">
 </c:otherwise>
     </c:choose> --%>
    <li class=" page-item ${pager.next? '' : 'disabled'}">
      <a class="page-link" href="./list.do?page=${pager.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a> 
    </li>
  </ul>
</nav>
			<div>
				<c:if test="${not empty sessionScope.member}">
				<a href="./add.do"><b>글작성✏</b></a>
				</c:if>
			</div>
	</section>
	<br>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>