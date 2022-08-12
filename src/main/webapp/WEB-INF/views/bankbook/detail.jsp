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
</head>
<body>
	<h2>조회 통장 상세보기</h2>
	
	<table border="1">
		<thead>
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBookNum()}</td>
				<td>${requestScope.detail.bookName}</td>
				<td>${detail.bookRate}</td>
				<td>${detail.bookSale}</td>
			</tr>
		</tbody>
	</table>
	<div>
	<hr>
	<a href="list.do">list보기</a>
	<a href="../member/login.do">로그인하기</a>
	<a href="update.do?bookNum=${detail.bookNum}">수정</a>
	<a href="delete.do?bookNum=${detail.bookNum}">삭제</a>
	<c:if test ="${not empty sessionScope.member}">
	<a href="../bankAccount/add.do?bookNum=${detail.bookNum}">가입하기</a>
	</c:if>
	</div>
</body>
</html>