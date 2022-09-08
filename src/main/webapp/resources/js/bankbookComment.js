//bankbookComment.js
const replyButton = document.getElementById("replyButton");
const writer = document.getElementById("writer");
const contents = document.getElementById("contents");
const commentList = document.getElementById("commentList");
const wr = document.querySelector("#wr");

//페이지 번호담는 변수
let page = 1;
//bookNum을 담을 변수
const bookNum = replyButton.getAttribute("data-booknum-num");
getCommentList(page, bookNum);

replyButton.addEventListener("click", function () {
  let wv = writer.value;
  if (wv == "") {
    writer.placeholder = "로그인이 필요합니다.";
    alert("로그인이 필요합니다.");
    return;
  }
  let cv = contents.value;
  // console.log(replyButton.data-booknum-num);
  //  console.log(replyButton.getAttribute("data-booknum-num"))

  //1. XMLHTTPRequest 생성
  const xhttp = new XMLHttpRequest();

  //2. url을 준비
  xhttp.open("POST", "./commentAdd");

  //3. Enctype
  //요청 header 정보
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  //4. 전송 (post일 경우 파라미터 추가)
  xhttp.send("bookNum=" + bookNum + "&writer=" + wv + "&contents=" + cv);

  //응답처리
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let result = xhttp.responseText.trim();
      result = JSON.parse(result);

      contents.value = "";
      if (result.comment == 1) {
        for (let i = 0; i < commentList.children.length; ) {
          commentList.children[0].remove();
        }

        page = 1;

        getCommentList(page, bookNum);
      }
    }
  };
});

//click 이벤트 끝
function getCommentList(p, bn) {
  //1.XMLHTTPRequest 생성
  const xhttp = new XMLHttpRequest();

  //2. Method, URL
  xhttp.open("GET", "./commentList?page=" + p + "&bookNum=" + bookNum);

  //3.요청 전송
  xhttp.send();

  //4. 응답 처리
  xhttp.addEventListener("readystatechange", function () {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      //1.jsp사용한 결과물
      // commentList.innerHTML=xhttp.responseText;

      //2.json결과물
      let result = JSON.parse(xhttp.responseText.trim());
      //jsp에 테이블 만들었음
      // let result = document.createElement('table');
      // let resultAttr = document.createAttribute("class");
      // resultAttr.value = "table";
      // result.setAttributeNode(resultAttr);

      let pager = result.pager; //commentPager
      let ar = result.list; // 댓글리스트
      // commentList.innerHTML=""; 다 지우고 빈문자열

      if (page == 1) {
        let tr2 = document.createElement("tr");
        let th = document.createElement("th");
        let th_text = document.createTextNode("글내용");
        th.appendChild(th_text);
        tr2.appendChild(th);

        th = document.createElement("th");
        th_text = document.createTextNode("작성자");
        th.appendChild(th_text);
        tr2.appendChild(th);

        th = document.createElement("th");
        th_text = document.createTextNode("작성일");
        th.appendChild(th_text);
        tr2.appendChild(th);

        th = document.createElement("th");
        th_text = document.createTextNode("");
        th.appendChild(th_text);
        tr2.appendChild(th);

        th = document.createElement("th");
        th_text = document.createTextNode("");
        th.appendChild(th_text);
        tr2.appendChild(th);

        commentList.append(tr2);
      }

      for (let i = 0; i < ar.length; i++) {
        let tr = document.createElement("tr");

        let td = document.createElement("td");
        let t = document.createTextNode(ar[i].contents);
        td.appendChild(t);
        tr.appendChild(td);

        td = document.createElement("td");
        let w = document.createTextNode(ar[i].writer);
        td.appendChild(w);
        tr.appendChild(td);

        td = document.createElement("td");
        let e = document.createTextNode(ar[i].regDate);
        // let date = new Date(ar[i].regDate);
        // let y = document.createTextNode(date.getFullYear()+"년 ");
        // let m = document.createTextNode((date.getMonth()+1)+"월 ");
        // let d = document.createTextNode(date.getDate()+"일");
        // td.appendChild(y);
        // td.appendChild(m);
        // td.appendChild(d);
        td.appendChild(e);
        tr.appendChild(td);

        td = document.createElement("td");
        let tdAttr = document.createAttribute("class");
        tdAttr.value = "update";
        td.setAttributeNode(tdAttr);
        tdAttr = document.createAttribute("data-comment-num");
        tdAttr.value = ar[i].num;
        td.setAttributeNode(tdAttr);
        let tdText = document.createTextNode("✏️");
        td.appendChild(tdText);
        tr.appendChild(td);

        td = document.createElement("td");
        tdAttr = document.createAttribute("class");
        tdAttr.value = "delete";
        td.setAttributeNode(tdAttr);
        tdAttr = document.createAttribute("data-comment-num");
        tdAttr.value = ar[i].num;
        td.setAttributeNode(tdAttr);
        tdText = document.createTextNode("🗑️");
        td.appendChild(tdText);
        tr.appendChild(td);

        commentList.append(tr);

        if (page >= pager.totalPage) {
          more.classList.add("disabled");
        } else {
          more.classList.remove("disabled");
        }
      }

      // let t = commentList.children;
      // if(t.length !=0){
      //     commentList.children[0].remove();
      // }
      // try {
      //     console.log(commentList.children);
      //     throw new Error("error발생🤣");
      // }catch(exception){

      // }finally{

      // }
      // commentList.append(result);
    }
  });
}

//------------------더보기 : 더 없으면 비활성화 시키기
const more = document.getElementById("more");

more.addEventListener("click", function () {
  page++; //page = page+1;
  getCommentList(page, bookNum);
});

//----------------------------수정, 삭제

commentList.addEventListener("click", function (event) {
  console.log(event.target);
  //Update
  if (event.target.className == "update") {
    // console.log(contents);
    // let v = contents.innerHTML;
    // contents.innerHTML="<textarea>"+v+"</textarea>";
    
    let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
    let num = event.target.getAttribute("data-comment-num");
    
    //수정input에 문자가져오기
    document.getElementById('updateContent').value = contents;
    //이벤트 강제 발생
    document.querySelector("#up").click();
    //num번호 가져오기
    document.querySelector('#num').value=num;




  }

  //Delete
  if (event.target.className == "delete") {
    let check = window.confirm("삭제 하시겠습니까?");
    if (check) {
      let num = event.target.getAttribute("data-comment-num");
      console.log("num : " + num);

      //1.XMLHTTP Request
      const xhttp = new XMLHttpRequest();

      //2. 요청정보(url,method)
      xhttp.open("POST", "commentDelete");

      //3. Header (enctype);
      xhttp.setRequestHeader(
        "Content-type",
        "application/x-www-form-urlencoded"
      );

      //4. 요청(파라미터와 함께)
      xhttp.send("num=" + num);

      //5. 응답 처리
      xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
          let result = xhttp.responseText.trim();
          console.log(result);
          if (result == 1) {
            console.log("삭제 성공");
            page = 1;
            for (let i = 0; i < commentList.children.length; ) {
              commentList.children[0].remove();
            }

            getCommentList(page, bookNum);
          } else {
            console.log("삭제 실패");
          }
        }
      };
    }
  }
});

//----------------------Modal Update button Click----------------------
const updateButton = document.querySelector('#updateButton');

updateButton.addEventListener("click", function(){
  //modal에서 num, contents를 가지고 와서 넘김.
  let num = document.getElementById("num").value;
  let updateContents = document.querySelector("#updateContent").value;


  //1.xmlhttp request 생성
  const xhttp = new XMLHttpRequest();
  //2.요청정보(url, method)
  xhttp.open("POST", "commentUpdate");
  //3.Header정보 ENCTYPE
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  //4.요청실행(파라미터와 함께)
  xhttp.send("num="+num+"&contents="+updateContents);
  //5. 응답처리
  xhttp.onreadystatechange = function(){
    if(xhttp.readyState == 4 && xhttp.status == 200){
      let result = xhttp.responseText.trim();
      if(result > 0){
        //리스트 초기화 및 재 나열
        for (let i = 0; i < commentList.children.length;) {
          commentList.children[0].remove();
        }
        page = 1;
        getCommentList(page, bookNum);
      }else {
        alert("수정 실패");
      }
    }
  }



});