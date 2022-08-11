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
</head>
<body>
<div class="contain">
	<h1>통장리스트</h1>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail  jsp:detail.jsp -->
	<!-- link 주소는 상대경로로 작성 -->
	<!-- /bankbook/detail 절대경로, ./detail or detail상대경로-->
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>	
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="detail?bookNum=${dto.getBookNum()}">${dto.bookName}</a></td>
				<td>${pageScope.dto.bookRate}</td>
			</tr>
		</c:forEach>
			
		
		<%--	 <% for(BankBookDTO dto : ar){ %>
					<tr>
						<td><a href="./detail?bookNum=<%= dto.getBookNum() %>"><%= dto.getBookName() %></a></td>
						<td><%= dto.getBookRate() %></td>
					</tr>
			<%} %> --%>
		</tbody>
	</table>
	<div>
		<a href="add">상품등록</a>
	</div>
	<div>
	<a href="/">홈으로</a>
	</div>
	</div>
</body>
</html>