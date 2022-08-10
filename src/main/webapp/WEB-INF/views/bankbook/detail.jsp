<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	BankBookDTO dto = (BankBookDTO)request.getAttribute("detail");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>조회 통장 상세보기</h2>
	
	<%if(dto != null) {%>
	<table border="1">
		<thead>
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=dto.getBookNum() %></td>
				<td><%=dto.getBookName() %></td>
				<td><%=dto.getBookRate() %></td>
				<td>
				<%if(dto.getBookSale() == 1){ %>
					판매중
				<%}else { %>
					판매금지
				<%} %>
				</td>
			</tr>
		</tbody>
	</table>
	<%} else{%>
		<h3>Data가 없다.</h3>
	<%} %>
	<!-- 상대경로 -->
	<a href="../member/login">로그인</a>
	<!-- 절대경로 -->
	<a href="/member/join">회원가입</a>
</body>
</html>