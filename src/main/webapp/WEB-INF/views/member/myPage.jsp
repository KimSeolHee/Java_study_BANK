<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="mt-5 mb-3"><h2>myPage🥰</h2></div>
<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Id</th><th>NAME</th><th>EMAIL</th><th>PHONE</th>
			</tr>
		</thead>
	<tbody>
		<tr>
			<td>${requestScope.dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			</tr>
		</tbody>
			</table>
	<table class="table table-striped table-hover">
	<thead>
			<tr>
				<th>accountNum</th><th>bookName</th><th>accountDate</th>
			</tr>
	</thead>
	<c:forEach items="${dto.bankAccountDTOs}" var="dto">
	<tr>
			<td>${pageScope.dto.accountNum}</td>
			<td>${dto.bankBookDTO.bookName}</td>	
			<td>${dto.accountDate}</td>	
	</tr>
			</c:forEach>
	</tbody>
	
<%-- <c:forEach items="${list}" var="dto">
		<p>${pageScope.dto.accountNum}</p>
		<p>${dto.bankBookDTO.bookName}</p>
		<p>${dto.accountDate}</p>
	</c:forEach> --%>

<%-- <h1>${map}</h1>
	<p>ID : ${map.dto.id}</p>
	<p>NAME : ${map.dto.name}</p>
	<p>EMAIL : ${map.dto.email}</p>
	<p>PHONE : ${map.dto.phone}</p>
	<c:forEach items="${map.list}" var="dto">
		<p>${dto.accountNum}</p>
		<p>${dto.bankBookDTO.bookName}</p>
		<p>${dto.accountDate}</p>
	</c:forEach> --%>
	
	</table>
	</section>
	<br>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>