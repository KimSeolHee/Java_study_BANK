function check() {
//   const all = document.getElementById("all");
const all = document.querySelector(#all);
  //   const cb = document.getElementsByClassName("cb");
  const cb = document.querySelectorAll(".cb");
  const req = document.getElementsByClassName("req");
  const join = document.getElementById("join");
  const frm = document.getElementById("frm");

//   cb.foreach(function (v, i, ar) {
//     console.log(v);
//   });

  all.addEventListener("click", function () {
    for (let i = 0; i < cb.length; i++) {
      cb[i].checked = all.checked;
    }
  });

  for (let i = 0; i < cb.length; i++) {
    cb[i].addEventListener("click", function () {
      let result = true;
      for (let j = 0; j < cb.length; j++) {
        if (!cb[j].checked) {
          result = false;
          break;
        }
      }
      all.checked = result;
    });
  }

  join.addEventListener("click", function () {
    let result = true;
    for (let i = 0; i < req.length; i++) {
      if (!req[i].checked) {
        result = false;
        break;
      }
    }
    if (result) {
      frm.submit(); //():강제발생
    } else {
      alert("이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.");
    }
    // if(all.checked){
    //     frm.submit();
    // }else{
    //     alert('이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.');
    // }
  });
}
