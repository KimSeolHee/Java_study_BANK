const d2 = document.getElementById('d2');
const d1 = document.getElementById('d1');
const d3 = document.getElementById('d3');
const d5 = document.getElementById('d5');
const d4 = document.getElementById('d4');
const sp = document.getElementById('sp');

d2.focus();

d2.addEventListener("focus", function(){
    console.log("입력준비")
})

d1.addEventListener("blur", function(){
    if(d1.value.length <= 3){
        d1.focus();
    }
});

d3.addEventListener("change", function(){
    console.log("change 이벤트발생");

});

d5.addEventListener("change", function(){
    console.log("click확인")
});

d4.addEventListener("keyup", function(){
    sp.innerHTML=d4.value.length * 1000;
});

// d4.addEventListener("keydown", function(){
//     sp.innerHTML=((d4.value.length)+1) * 1000;
// })

// 1000를 곱해서 span에서 띄운다.