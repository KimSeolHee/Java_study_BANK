const btn1 = document.getElementById('btn1');
const form = document.getElementById('form');
const id = document.getElementById('id');
const pw = document.getElementById('pw');
const lav = document.getElementById('lav');

btn1.addEventListener('click', function(){
    let u = id.value;
    let p = pw.value;
    console.log(u=="");
    console.log(u.length);


    if(u==""){
        lav.innerHTML = "id틀렸어요";
        return;
    }
    if(p==""){
        lav.innerHTML = "pw틀렸어요";
        return;
    }

    if(u.length>0 && p.length>0){
        form.submit();
    }

    // if(id.getAttribute("value").includes() && pw.getAttribute("value").includes()){
    //     form.submit();
    // }else {
    //     alert("정보를 입력하세요");
    // }
});
