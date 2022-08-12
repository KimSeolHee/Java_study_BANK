<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h2>통장 수정</h2>
<hr>
	    <div>
        <form action="update.do" method="post">
            <div class="container">
                <div>
                	<input type="hidden" name="bookNum" value="${dto.bookNum}" >
                	<h4>통장이름</h4>
                    <input type="text" name = "bookName" value="${dto.bookName}">
                </div>
                <div>
                	<h4>이자율</h4>
                    <input type="number" step="0.01" name = "bookRate" value="${dto.getBookRate()}">
                </div>
                    <form >
                        <div>
                            <input type="submit" value="수정하기">
                        </div>
              
                    </form>
            </div>    
        </form>
    </div>
</body>
</html>