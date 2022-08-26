<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%--   <%
    		//스크립틀릿 <% 사이에 java code작성% >
    		// 표현식 <%=자바변수 또는 값% >
    		ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
    %> --%>
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
<div class="container col-lg-6">
	<br>
	<div class="mb-3 mt-5">	
	<h2 style="text-align:center;">통장리스트📖</h2>
</div>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">제목</th>
      <th scope="col">이율</th>
      <th scope="col">내용</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${list}" var="dto">
    <tr>
      <td><a href="detail.do?bookNum=${dto.getBookNum()}">${dto.bookName}</a></td>
	  <td>${pageScope.dto.bookRate}</td>
	  <td>${pageScope.dto.bookContents}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<div class="mb-5 mt-4" style="text-align:right;">
		<button class="btn btn-dark mb-3 text-white"><a href="add.do" style="text-decoration:none; color: white;">상품등록</a></button>
	</div>
	</div>
		<br>
		<br>
		<br>
		<br>
				<br>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>