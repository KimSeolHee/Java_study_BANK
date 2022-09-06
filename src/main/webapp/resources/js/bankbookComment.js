//bankbookComment.js
const replyButton = document.getElementById('replyButton');
const writer = document.getElementById('writer');
const contents = document.getElementById('contents');
const commentList = document.getElementById('commentList');


getCommentList();

replyButton.addEventListener("click", function(){

    let bookNum = replyButton.getAttribute("data-booknum-num")
    let wv = writer.value;
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
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //응답처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4&& this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);
            if(result.result == 1){
                alert("댓글등록 성공");
                getCommentList();
            }
        }
    }
});

//click 이벤트 끝
function getCommentList(){
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    xhttp.open("GET", "./commentList?page=1&bookNum=1662341815744");

    //3.요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4&&xhttp.status==200){
            console.log(xhttp.responseText);
            //1.jsp사용한 결과물
            // commentList.innerHTML=xhttp.responseText;
            
            //2.json결과물
            let ar = JSON.parse(xhttp.responseText.trim());
            let result = document.createElement('table');
            let resultAttr = document.createAttribute("class");
            resultAttr.value = "table";
            result.setAttributeNode(resultAttr);

            for(let i = 0;i <ar.length;i++){
                let tr = document.createElement('tr');

                let td = document.createElement('td');
                let t = document.createTextNode(ar[i].contents);
                td.appendChild(t);
                tr.appendChild(td);

                td = document.createElement('td');
                let w = document.createTextNode(ar[i].writer);
                td.appendChild(w);
                tr.appendChild(td);

                td = document.createElement('td');
                let d = document.createTextNode(ar[i].regDate);
                td.appendChild(d);
                tr.appendChild(td);            
                result.append(tr);

            }
                commentList.append(result);

        }
    })

}
















