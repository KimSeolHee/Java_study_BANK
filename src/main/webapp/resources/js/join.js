const id = document.getElementById('id');
const text = document.getElementById('text');
const pw = document.getElementById('pw');
const pwtext = document.getElementById('pwtext');
const pw2 = document.getElementById('pw2');
const pw2_text = document.getElementById('pw2_text');
const you = document.getElementById('you');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const youtext = document.getElementById('youtext');
const emailtext = document.getElementById('emailtext');
const phonetext = document.getElementById('phonetext');
const btn = document.getElementById('btn');
const frm = document.getElementById('frm');

id.focus();
let idCheck = false;
let pwCheck = false;
let pwEqualCheck = false;
let nameCheck = false;
let emailCheck = false;
let phoneCheck = false;

id.addEventListener("blur", function(){
    if(id.value.length < 2){
        text.innerHTML="ID는 최소 2글자 이상이여야 합니다.";
        id.focus();
    }else{
        text.innerHTML = "";
        idCheck = true;
    }
})

pw.addEventListener("change", function(){
    if(pw.value.length < 7){
        pwtext.innerHTML="PW는 최소 7글자 이상이여야 합니다.";
        pw.focus();
    }else{
        pwtext.innerHTML = "";
        pwCheck = true;
    }
})


pw2.addEventListener("blur", function(){
    if(!(pw.value == pw2.value)){
        pw2_text.innerHTML = "비번이 일치하지 않습니다.";
        pw2.focus();
    } else{
        pw2_text.innerHTML = "같은 비번 확인😚";
        pwEqualCheck = true;
        console.log(pw2.value);
        pw2.innerHTML = "";
        console.log(pw2.value);
    }
});


you.addEventListener("blur", function(){
    if(you.value.length < 1){
        youtext.innerHTML = "한글자 이상 입력하세요";
        you.focus()
    }else{
        youtext.innerHTML = "";
        nameCheck = true;
    }
})

email.addEventListener("blur", function(){
    if(email.value.length < 1){
        emailtext.innerHTML = "한글자 이상 입력하세요";
        email.focus()
    }else{
        emailtext.innerHTML = "";
        emailCheck = true;
    }
})

phone.addEventListener("blur", function(){
    if(phone.value.length < 1){
        phonetext.innerHTML = "한글자 이상 입력하세요";
        phone.focus()
    }else{
        phonetext.innerHTML = "";
        phoneCheck = true;
    }
})

btn.addEventListener("click", function(){
    if(idCheck&&pwCheck&&pwEqualCheck&&nameCheck&&emailCheck&&phoneCheck){
        frm.submit();
    }else{
        alert("조건이 일치 하지 않습니다.");
    }
}
)


