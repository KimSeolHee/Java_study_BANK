<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 작성✍️</h2>
	    <div>
        <form action="./add.do" method="post">
            <div>
                <div>
                	<h3>제목</h3>
                    <input type="text" name = "title" placeholder="글제목">
                </div>
                 <div>
                	<h3>내용</h3>
                    <input type="text" name = "content" placeholder="내용을 입력해주세요">
                </div>
                <hr>
                <div>
                	<span><b>작성자</b></span>
                </div>              	
                    <input type="text" name = "writer" readonly value="${member.id}">
                    <form >
                        <div>
                            <input type="submit" value="글작성">
                        </div>
                    </form>
            </div>    
        </form>
    </div>
</body>
</html>