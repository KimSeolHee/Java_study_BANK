<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	    <div>
        <form action="./login" method="post">
            <div class="container">
                <h2>ID 로그인</h2>
                <div>
                    <input type="text" name = "id" placeholder="아이디">
                </div>
                <div>
                    <input type="password" name = "pw" placeholder="비밀번호">
                </div>
                    <form >
                        <div class="login">
                            <input type="submit" value="로그인">
                        </div>
                        <div>
                            <a href="/">뒤로가기</a>
                        </div>
                    </form>
            </div>    
        </form>
    </div>
</body>
</html>