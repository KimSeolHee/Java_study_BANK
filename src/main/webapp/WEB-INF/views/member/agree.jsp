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
    <div class="mt-5 mb-3"><h2>약관동의</h2></div>
				    <div class="col-sm-10">
				    <div>
				    <label class="col-sm-4 col-form-label" style="color: red;"><b>전체동의</b></label>
				    </div>
				      <input type="checkbox"  name = "agree" id="all">
				    <div>
				    <label class="col-sm-4 col-form-label">1번</label>
				    </div>
				      <input type="checkbox"  name = "agree" class = "req cb">
				    <div>
				    <label class="col-sm-4 col-form-label">2번</label>
				    </div>
				      <input type="checkbox"  name = "agree"  class = "req cb">
            <div>
              <label class="col-sm-4 col-form-label">3번</label>
            </div>
				      <input type="checkbox"  name = "agree"  class = "cb">
		</div>
				   <div class="col-auto pt-3 mb-3">
				   <form action="join.do" id="frm">
				    <button type="button" id="join" class="btn btn-dark mb-3 text-white">회원가입</button>
				    </form>
			   </div>
    </div>
<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/agree.js"></script>
<script>
  check();
</script>
</body>
</html>