<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    		//스크립틀릿 <% 사이에 java code작성% >
    		// 표현식 <%=자바변수 또는 값% >
    		ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장리스트</h1>
	<!-- /bankbook/list -->
	
	<a href="./detail">DETAIL</a>
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
			<% for(BankBookDTO dto : ar){ %>
					<tr>
						<td><a href="./detail?bookNum=<%= dto.getBookNum() %>"><%= dto.getBookName() %></a></td>
						<td><%= dto.getBookRate() %></td>
					</tr>
			<%} %>
		</tbody>
	</table>
	
</body>
</html>