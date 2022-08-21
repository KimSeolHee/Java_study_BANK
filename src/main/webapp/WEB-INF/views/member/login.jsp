<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container mt-5 col-lg-5">
 	<form action="./login.do" method="post">
		<div class="row">
			  <div class="mb-3 row">
			    <div>
			    <label for="staticEmail" class="col-sm-2 col-form-label">id</label>
			    </div>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name = "id" placeholder="아이디">
			    </div>
			  </div>
			  <div class="mb-3 row">
			  <div>
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    </div>
			    <div class="col-sm-10">
			      <input type="password" class="form-control"  name = "pw" placeholder="패스워드">
			    </div>
			    <div class="form-check pt-3 ">
				  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
				  <label class="form-check-label" for="flexCheckDefault">
				    자동로그인 저장
				  </label>
				</div>
			    <div class="col-auto pt-3 mb-3">
				    <button type="submit" class="btn btn-primary mb-3 bg-dark text-white">로그인</button>
				 </div>
			  </div>
		</div>
	</form>
	</section>
    <c:import url="../template/footer.jsp"></c:import>
</body>
</html>