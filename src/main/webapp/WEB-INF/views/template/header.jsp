<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <nav
      class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light "
    >
      <div class="container-fluid ">
        <a class="navbar-brand" href="#"><img src="https://fncent.com/layouts/default/image/common/logo.png"></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup" style="padding-right: 150px;">
          <div class="navbar-nav">
            <a class="nav-link active" aria-current="page" href="/">홈</a>
     		<c:choose>
	          <c:when test="${not empty sessionScope.member}">
			    <a class="nav-link active" href="/member/myPage.do">마이페이지</a>
			    <a class="nav-link active" href="/member/Logout.do">로그아웃</a>
		      </c:when>
		      <c:otherwise>
			    <a class="nav-link active" href="/member/login.do">로그인</a>
			    <a class="nav-link active" href="/member/agree.do">회원가입</a>
		      </c:otherwise>
		      </c:choose>
            <a class="nav-link active" href="/bankbook/list.do">상품리스트</a>
            <a class="nav-link active" href="/member/search.do">회원검색</a>
            <a class="nav-link active" href="/notice/list.do">공지사항</a>
            <a class="nav-link active" href="/qna/list.do">QNA</a>
          </div>
        </div>
      </div>
    </nav>