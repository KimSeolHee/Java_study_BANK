const addFiles = document.getElementById('addFiles');
const fileAdd = document.getElementById('fileAdd');
const div3 = document.getElementById('div3');

let count = 0;

fileAdd.addEventListener("click", function(){
    count = count +1;
    if(count > 5){
        alert("최대 5개만 가능");
        return
    }
    //부모 Element div생성
    let div =document.createElement('div');
    let c= document.createAttribute('class');
    c.value = "form-group pt-3";
    div.setAttributeNode(c);
    addFiles.append(div); 
            
    //자식 Element Label생성
    let label = document.createElement('label');
    let labelText = document.createTextNode('file');
    label.appendChild(labelText)
    let labelClass = document.createAttribute('class');
    labelClass.value = "form-label"
    label.setAttributeNode(labelClass);
    labelClass = document.createAttribute('for');
    labelClass.value= "files";
    label.setAttributeNode(labelClass);
        
    //div에 label을 넣어줌
    div.appendChild(label);
            
//input태그만들기
    let input = document.createElement('input');
    let type = document.createAttribute('type');
    type.value = "file";
    input.setAttributeNode(type);
    let cl = document.createAttribute('class');
    cl.value = "form-control";
    input.setAttributeNode(cl);
    let n = document.createAttribute('name');
    n.value = "files";
    input.setAttributeNode(n);
    let id = document.createAttribute('id');
    id.value = "files";
    input.setAttributeNode(id);
        
    //div안에 input태그 넣기
    div.appendChild(input);
        
    //addFiles에 div를 append함
    addFiles.append(div);
    });     


