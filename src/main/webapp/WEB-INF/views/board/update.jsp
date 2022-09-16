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
		<div class="mt-5 mb-3"><h2 style="text-align:center;">${board} 수정👩‍🔧‍</h2></div>
		<form action="./update.do" method="post" enctype="">
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
			<div class="mt-3 mb-3" style="text-align:right;">
			<input class="btn btn-dark mb-3 text-white" type="submit" value="수정하기">
			</div>
	
	   <c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
               <div class="mb-3">
               	<span class="form-control">${fileDTO.oriName}</span>
                  <button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
               </div>
    	</c:forEach>
		<div id="addFiles">
			<button class="btn btn-dark mb-3 text-white" type="button" id="fileAdd">파일추가</button>
		</div>	

		</form>
	</section>
	
	
<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/board.js"></script>
<script>
	setCount(${boardDTO.boardFileDTOs.size()});
</script>
</body>
</html>