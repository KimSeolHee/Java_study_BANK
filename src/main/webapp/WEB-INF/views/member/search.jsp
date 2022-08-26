<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="https://kit.fontawesome.com/6e23c67242.js" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class=" container mt-5 mb-5 col-lg-5"style="text-align:center;">
		<div class="mb-3">
	<br>
	<br>
		<div><h2>사용자 조회🕵️‍♀️</h2></div>
	<br>
		</div>
		<form action="search.do" method="post">
			<div class="input-group  col-lg-8" style="justify-content: center;">
				  <div id="search-autocomplete" class="form-outline">
				    <input type="search"  name="id" class="form-control" placeholder="조회할 id입력" />
				  </div>
			  <button type="submit" class="btn btn-dark text-white">
			    <i class="fas fa-search"></i>
			  </button>
		</div>
	</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>