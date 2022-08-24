<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%-- <%
  		//요청이 발생하면 생성, 응답이 나가면 소멸 RequestScope
    	BankBookDTO dto = (BankBookDTO)request.getAttribute("detail");
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
	<div class="mb-2 mt-5"><h2>조회 통장 상세보기📋</h2></div>
	<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이율</th>
      <th scope="col">판매여부</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${requestScope.detail.getBookNum()}</td>
	  <td>${detail.bookRate}</td>
	  <td>${detail.bookSale}</td>
    </tr>
  </tbody>
</table>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label"><b>통장이름</b></label>
			<input type="text" readonly class="form-control" id="exampleFormControlInput1" value="${requestScope.detail.bookName}">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label"><b>상세내용</b></label>
			<textarea class="form-control" readonly id="exampleFormControlTextarea1" rows="5">${detail.bookContents}</textarea>
		</div>
	<div class="mt-4 mb-4">
	<a href="update.do?bookNum=${detail.bookNum}">수정</a>
	<a href="delete.do?bookNum=${detail.bookNum}">삭제</a>
	<c:if test ="${not empty sessionScope.member}">
	<a href="../bankAccount/add.do?bookNum=${detail.bookNum}">가입하기</a>
	</c:if>
	</div>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>