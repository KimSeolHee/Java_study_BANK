<%@page import="com.iu.start.member.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list");
    System.out.println(ar);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 상세보기🔎</h1>
	
	<table border="2">
		<thead>
			<tr>
				<th>Id</th><th>Pw</th><th>Name</th><th>Email</th><th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<%  for(BankMembersDTO dto:ar) {%>
			<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getPhone() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
</body>
</html>