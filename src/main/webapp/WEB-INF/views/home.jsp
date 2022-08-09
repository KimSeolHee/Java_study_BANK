<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href = "./member/login">Login</a>
<a href = "./member/join">Join</a>
<a href = "./bankbook/list">LIST</a>
<a href = "./bankbook/detail">Detail</a>
<div>
<a href = "./bankbook/add">ADD</a>
</div>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
