<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="mb-3"><h4>글 작성✍️</h4></div>
        <form action="./add.do" method="post">
        	  <div class="form-group pt-3">
				    <div><label for="exampleFormControlInput1">제목</label></div>
				    <input type="text" name = "title" placeholder="글제목" class="form-control" id="exampleFormControlInput1">
			  </div>
        
        		  <div class="form-group pt-3">
				    <div><label for="exampleFormControlTextarea1">내용</label></div>
				    <textarea name = "contents" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
				  </div>
                 <div class="form-group pt-3">
				    <div><label for="exampleFormControlInput1">작성자</label></div>
				    <input type="text"  name = "writer" readonly value="${member.id}" class="form-control" id="exampleFormControlInput1">
				  </div>
                        <div class="mt-4 mb-5">
                            <input class="btn btn-primary mb-3 bg-dark text-white" type="submit" value="글작성">
                        </div>
                    </form>
            </div>    
              <c:import url="../template/footer.jsp"></c:import>    
</body>
</html>