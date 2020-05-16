

// alertbanner shippingbanner(jquery)
var $abanner = $('#alertbanner');
var $sbanner = $('#shippingbanner');
var $cbanner = $('#cartbanner');
//최초 시작값
$abanner.css({'top':'-50px'});
$sbanner.css({'top':'-100px'});
//애니메이션 값
$abanner.animate({'top':'1px'},500,function(){
    $sbanner.animate({'top':'1px'},600);
});

//cartbanner 
$cbanner.css({"opacity":1});
$cbanner.onclick({"opacity":0},500);


// 로그인
var loginBtn = document.getElementById("login");
var modal = document.getElementById("id01");
// var close = document.getElementsByClassName("close")[0];

loginBtn.onclick = function(){
    modal.style.display = "block";
}
close.onclick = function(){
    modal.style.display = "none";
}
window.onclick = function(event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}

//
function w3_open() {
    document.getElementById("mySidebar").style.width = "100%";
    document.getElementById("mySidebar").style.display = "block";
  }
  
  function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
  }
      
    



// join form vaildation
// email 패턴에 대한 정규표현식
var emailPat = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

function chkSubmit(){
	var frm = document.forms.joinform;
	var email = frm.email.value.trim();

	document.getElementById("emailwarn").innerHTML = "";

	//정규표현식 객체의 test() : 패턴 매칭 여부 

	if(!emailPat.test(email)){
		document.getElementById("emailwarn").innerHTML = " 잘못된 email 입니다";
		frm.email.focus();
		return false;
	}
    return true;
    
    // var a = confirm("제출하시겠습니까?");
    // if(a){
	// 	frm.submit();
	// }
}
