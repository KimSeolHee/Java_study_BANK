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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
    <div class="container mt-5 col-lg-5">
    <div class="mt-5 mb-3"><h2>회원가입💻</h2></div>
        <form action="join.do" method="post" >
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
				    <div>
				    <label for="name" class="col-sm-2 col-form-label">Name</label>
				   </div>
				    <div class="col-sm-10">
				      <input type="text" class="form-control"  name = "name" placeholder="이름">
				   </div>
				   <div>
				    <label for="email" class="col-sm-2 col-form-label">email</label>
				   </div>
				   <div class="input-group mb-3">
					  <input type="text" name="email" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
					  <span class="input-group-text" id="basic-addon2">@example.com</span>
					</div>
					 <div>
				    <label for="phone" class="col-sm-2 col-form-label">Phone</label>
				   </div>
				    <div class="col-sm-10">
				      <input type="number" class="form-control"  name = "phone" placeholder="휴대전화입력">
				   </div>
				   <div class="col-auto pt-3 mb-3">
				    <button type="submit" class="btn btn-dark mb-3 text-white">가입하기</button>
				 </div>
				   
			  	 </div>
			   </div>
        </form>
    </div>
        <c:import url="../template/footer.jsp"></c:import>
</body>
</html>