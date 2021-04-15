/**
 *
 */

  var eleSubmit = document.getElementById("submitBtn");
eleSubmit.onclick = function(){
	var firstPass = document.getElementById("passwordOne");
	var secondPass = document.getElementById("passwordTwo");

	var canSubmit = true;
	if(firstPass.value != secondPass.value){
		alert("パスワードが異なっています");
		firstPass.value="";
		secondPass.value="";
		canSubmit=false;
	}
	return canSubmit;

}
$(function(){
	$('.new').css('color', 'Red');
});