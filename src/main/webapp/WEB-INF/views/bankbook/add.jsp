<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>통장 추가</h2>
	    <div>
        <form action="./add.do" method="post">
            <div class="container">
                <div>
                	<h3>통장이름</h3>
                    <input type="text" name = "bookName" placeholder="통장명 입력">
                </div>
                <div>
                	<h3>이자율</h3>
                    <input type="number" step="0.01" name = "bookRate" placeholder="이자율">
                </div>
                    <form >
                        <div class="login">
                            <input type="submit" value="추가하기">
                        </div>
                    </form>
            </div>    
        </form>
    </div>
</body>
</html>