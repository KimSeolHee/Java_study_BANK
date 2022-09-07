<%@page import="com.iu.start.bankBook.BankBookDTO"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- <% //요청이 발생하면
생성, 응답이 나가면 소멸 RequestScope BankBookDTO dto =
(BankBookDTO)request.getAttribute("detail"); %> --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
    <section class="container-fluid con-lg-7">
      <div class="container col-lg-6">
        <br />
        <div class="mb-2 mt-5">
          <h2 style="text-align: center">조회 통장 상세보기📋</h2>
        </div>
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">번호</th>
              <th scope="col">이율</th>
              <th scope="col">판매여부</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${requestScope.detail.getBookNum()}</td>
              <td>${detail.bookRate}</td>
              <td>${detail.bookSale}</td>
            </tr>
          </tbody>
        </table>
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label"
            ><b>통장이름</b></label
          >
          <input
            type="text"
            readonly
            class="form-control"
            id="exampleFormControlInput1"
            value="${requestScope.detail.bookName}"
          />
        </div>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label"
            ><b>상세내용</b></label
          >
          <textarea
            class="form-control"
            readonly
            id="exampleFormControlTextarea1"
            rows="5"
          >
${detail.bookContents}</textarea
          >
        </div>
        <div class="mt-4 mb-4" style="text-align: right">
          <button class="btn btn-dark mb-3 text-white">
            <a
              href="update.do?bookNum=${detail.bookNum}"
              style="text-decoration: none; color: white"
              >수정</a
            >
          </button>
          <button class="btn btn-dark mb-3 text-white">
            <a
              href="delete.do?bookNum=${detail.bookNum}"
              style="text-decoration: none; color: white"
              >삭제</a
            >
          </button>
          <c:if test="${not empty sessionScope.member}">
            <button class="btn btn-dark mb-3 text-white">
              <a
                href="../bankAccount/add.do?bookNum=${detail.bookNum}"
                style="text-decoration: none; color: white"
                >가입하기</a
              >
            </button>
          </c:if>
        </div>
        <!--Comment-->
        <div class="row">
          <div><h4>댓글🐱‍🐉</h4></div>
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">ID</label>
            <input
              type="text"
              class="form-control"
              readonly
              id="writer"
              placeholder="Enter your ID"
              value="${member.id}"
            />
          </div>
          <div class="mb-3">
            <label for="contents" class="form-label">Contents</label>
            <textarea class="form-control" id="contents" rows="3"></textarea>
          </div>
          <div>
            <button
              type="button"
              id="replyButton"
              class="btn btn-secondary"
              data-booknum-num="${detail.bookNum}"
            >
              댓글작성
            </button>
          </div>
          <div>
            <table
              id="commentList"
              class="table table-striped table-hover mt-4"
              style="text-align: center"
            ></table>
            <div class="d-grid gap-2 mb-3">
              <button id="more" class="btn btn-secondary btn-lg" type="button">
                더보기
              </button>
            </div>
          </div>

          <div>
            <button
              type="button"
              id="up"
              style="display: none"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#exampleModal"
              data-bs-whatever="@getbootstrap"
            >
              Open modal for @getbootstrap
            </button>

            <div
              class="modal fade"
              id="exampleModal"
              tabindex="-1"
              aria-labelledby="exampleModalLabel"
              aria-hidden="true"
            >
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">수정</h5>
                    <button
                      type="button"
                      class="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>
                  <div class="modal-body">
                    <form>
                      <div class="mb-3">
                        <label for="recipient-name" class="col-form-label"
                          >writer</label
                        >
                        <input
                          type="text"
                          class="form-control"
                          id="recipient-name"
                          value="${member.id}"
                          readonly
                        />
                      </div>
                      <div class="mb-3">
                        <label for="message-text" class="col-form-label"
                          >Contents</label
                        >
                        <textarea
                          class="form-control"
                          id="message-text"
                        ></textarea>
                      </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-bs-dismiss="modal"
                    >
                      취소
                    </button>
                    <button type="button" class="btn btn-primary">
                      수정하기
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <c:import url="../template/footer.jsp"></c:import>
    <script src="/resources/js/bankbookComment.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
