/**
 *
 */



 var userName =document.getElementsByName("UserName");
 var deleteName = document.getElementsByName("deleteUser");
 var deletebtn = document.getElementsByName("deleteBtn");

for(var i=0; i<deleteName.length; i++){

if(userName[i].value != deleteName[i].value){
deletebtn[i].style.display="none";
}

}

function deleteCheck() {
//確認ダイアログを表示する

var result = confirm( "本当に削除しますか？" );
if (result==true){
return true;
}else{
return false;
}
}






