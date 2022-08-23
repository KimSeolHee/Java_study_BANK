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
	<section class="container col-lg-8">
	<div class="mt-5 mb-3"><h2>Notice📢</h2></div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>num</th><th>title</th><th>writer</th><th>regDate</th><th>hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="boardDTO">
					<tr>
						<td>${pageScope.boardDTO.num}</td>
						<td><a href="./detail.do?num=${boardDTO.getNum()}">${pageScope.boardDTO.title}</a></td>
						<td>${pageScope.boardDTO.writer}</td>
						<td>${pageScope.boardDTO.regDate}</td>
						<td>${pageScope.boardDTO.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			<div>
				<c:if test="${not empty sessionScope.member}">
				<a href="./add.do"><b>글작성✏</b></a>
				</c:if>
				<a href="/"><b>Home🏘</b></a>
			</div>
	</section>
	<br>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>