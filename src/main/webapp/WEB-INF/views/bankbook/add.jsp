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
<div class="container col-lg-6 mt-5">
	<div class="mb-3"><h3>통장 추가📝</h3></div>
        <form action="./add.do" method="post">
		  <div class="form-group">
		    <div><label for="exampleFormControlInput1">통장이름</label></div>
		    <input type="text" name = "bookName" placeholder="통장명 입력" class="form-control" id="exampleFormControlInput1">
		  </div>
		  <div class="form-group">
			<div><label for="exampleFormControlInput1">이자율</label></div>
		    <input type="number" step="0.01" name = "bookRate" placeholder="이자율" class="form-control" id="exampleFormControlInput1">
		  </div>
		  <div class="form-group">
		    <div><label for="exampleFormControlTextarea1">상세설명</label></div>
		    <textarea name = "bookContents" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		  </div>
            <div class="mt-3 mb-5">
              <input class="btn btn-primary mb-3 bg-dark text-white" type="submit" value="통장추가">
            </div>
       </form>
  </div>
  <c:import url="../template/footer.jsp"></c:import>    
</body>
</html>