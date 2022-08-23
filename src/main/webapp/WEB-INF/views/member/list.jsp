<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:import url="../template/header.jsp"></c:import>
<div class="container col-lg-8">
	<div class="mt-5 mb-3"><h2>사용자 상세보기🔎</h2></div>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Id</th><th>Pw</th><th>Name</th><th>Email</th><th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.getId()}</td>
					<td>${pageScope.dto.pw}</td>	
					<td>${pageScope.dto.name}</td>	
					<td>${pageScope.dto.email}</td>
					<td>${pageScope.dto.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	</div>
	<br>
	 <c:import url="../template/footer.jsp"></c:import>
</body>
</html>