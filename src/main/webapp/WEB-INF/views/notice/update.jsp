<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container col-lg-6">
		<div class="mt-5 mb-3"><h2>게시글 수정👩‍🔧‍</h2></div>
		<form action="./update.do" method="post">
			<div class="form-group">
				<input type="hidden" name="num" value="${boardDTO.num}">
			</div>
			<div class="form-group">
				<div><label for="exampleFormControlInput1">제목</label></div>
				<input type="text" name="title" value="${boardDTO.title}" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="form-group">
				<div><label for="exampleFormControlInput1">내용</label></div>
				<textarea name = "contents" class="form-control mt-1" id="exampleFormControlTextarea1" rows="5">${boardDTO.contents}</textarea>
			</div>
			<div class="mt-3 mb-3">
			<input class="btn btn-primary mb-3 bg-dark text-white" type="submit" value="수정하기">
			</div>
		</form>
	</section>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>