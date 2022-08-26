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
<section class="container col-lg-6" style="text-align:center;">
<div class="mt-5 mb-3"><h2><b>마이페이지🥰</b></h2></div>
<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>아이디</th><th>이름</th><th>이메일</th><th>전화번호</th>
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
				<th>통장번호</th><th>통장명</th><th>가입일</th>
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
	<div class="card" style="width: 18rem; margin-left:auto;">
	  <img src="../resources/upload/member/${dto.membersFileDTO.fileName}" class="card-img-top" alt="...">
	</div>
	</section>
	<br>
	<br>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>