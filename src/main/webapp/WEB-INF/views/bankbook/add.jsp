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
	<div class="mb-3"><h2 style="text-align:center;">ν΅μ₯ μΆκ°π</h2></div>
        <form action="./add.do" method="post">
		  <div class="form-group">
		    <div><label for="exampleFormControlInput1">ν΅μ₯μ΄λ¦</label></div>
		    <input type="text" name = "bookName" placeholder="ν΅μ₯λͺ μλ ₯" class="form-control" id="exampleFormControlInput1">
		  </div>
		  <div class="form-group">
			<div><label for="exampleFormControlInput1">μ΄μμ¨</label></div>
		    <input type="number" step="0.01" name = "bookRate" placeholder="μ΄μμ¨" class="form-control" id="exampleFormControlInput1">
		  </div>
		  <div class="form-group">
		    <div><label for="exampleFormControlTextarea1">μμΈμ€λͺ</label></div>
		    <textarea name = "bookContents" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		  </div>
            <div class="mt-3 mb-5">
              <input class="btn btn-dark mb-3 text-white" type="submit" value="ν΅μ₯μΆκ°">
            </div>
       </form>
  </div>
  <c:import url="../template/footer.jsp"></c:import>    
</body>
</html>