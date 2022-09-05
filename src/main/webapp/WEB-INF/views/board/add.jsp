<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- jquery -->
    <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
        <!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<section class="container col-lg-6 mt-5">
<div class="mt-5 mb-4"><h2 style="text-align:center;">글 작성👩‍💻</h2><h5>${board}</h5></div>
	
		<form action="./add.do" method="post" enctype="multipart/form-data">
			<div class="form-group pt-3 ">
				<div class="mb-1"><label for="exampleFormControlInput1">제목</label></div>
				<input type="text" name = "title" placeholder="글제목" class="form-control" id="exampleFormControlInput1">
			</div>             
            <div class="form-group pt-3 ">
				<div class="mb-1"><label for="exampleFormControlInput1">작성자</label></div>
				    	<input type="text"  name = "writer" readonly value="${member.id}" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="mt-1">
				<div ><label  for="exampleFormControlInput1">글내용</label></div>
				<textarea name = "contents" class="form-control mt-1" id="contents" rows="5"></textarea>
			</div>

			<div id="addFiles">
				<button class="btn btn-dark mb-3 text-white" type="button" id="fileAdd">파일추가</button>
			</div>			
			
			<div class="mt-3 mb-4">
			<input class="btn btn-dark mb-3 text-white" type="submit" value="작성하기" >
			</div>			
		</form>
</section>
<c:import url="../template/footer.jsp"></c:import>    
<script src="/resources/js/board.js"></script>
<script type="text/javascript">
	$("#contents").summernote(
			{
				  height: 300,                
				  minHeight: null,           
				  maxHeight: null,          
				  focus: true 
				});
</script>
</body>
</html>