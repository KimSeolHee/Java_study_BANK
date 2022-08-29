//선택하고 작업
let d1 = document.getElementById('d1');
let d2 = document.getElementById('d2');
let d3 = document.getElementById('d3');
let year = document.getElementById('year');
let month = document.getElementById('month');
let date = document.getElementById('date');
let d4 = document.getElementById('d4');

// alert(d1.value);
alert(d1.getAttribute("value"));
alert(d2.setAttribute("type","button"));

let count = window.prompt("숫자를 입력하세요");
let t = "";

for(let i=0;i<count;i++){
    t = t+'<input type="text">';
}

d3.innerHTML = t;

for(let i = 1990; i < 2000; i++){
    t = t+'<option value="">'+i+'년'+'</option>';
}
year.innerHTML = t;

let s = "";
for(let i = 1; i < 13; i++){
    s = s+'<option value="">'+i+'월'+'</option>';
}
month.innerHTML = s;

let d = "";
for(let i = 1; i < 30; i++){
    d = d+'<option value="">'+i+'일'+'</option>';
}
date.innerHTML = d;

let r = prompt("ROW 갯수입력");
let c= prompt("colum 갯수입력");
let z = "";
for(let i = 0; i < c;i++){
    z = z+'<td>'+i+'</td>'
}

let g = "";
for(let i = 0; i < r;i++){
    g = g+'<tr>'+z+'</tr>'
}
d4.innerHTML = g;

