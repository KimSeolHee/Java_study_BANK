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
<div class="container col-lg-8">
	<div class="mb-2 mt-5">	
	<h3>통장리스트📖</h3>
	</div>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Rate</th>
      <th scope="col">Contents</th>
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
	<div class="mb-5 mt-2">
		<a href="add.do">상품등록</a>
		<a href="/">홈으로</a>
	</div>
	</div>
	
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>