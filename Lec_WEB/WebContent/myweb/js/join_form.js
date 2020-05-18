
function chkSubmit(){
    var frm = document.forms['joinform'];
    
    if(frm['firstname'].value.trim() == ""){
        alert("First Name 은 필수 입니다");
        frm['firstname'].focus()  
        return false;
    }
    
    return true; 
}

function chkSubmit5(){
	var frm = document.forms['form5'];

	if(frm['firstname'].value.trim() == ""){
		alert("First Name 은 필수 입니다");
		frm['firstname'].focus();
		return;   
	}
	var a = confirm("제출하시겠습니까?");

	if(a){
		frm.submit();
	}
}

// url 패턴에 대한 정규표현식
var urlPat = /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:[/?#]\S*)?$/i;

// email 패턴에 대한 정규표현식
var emailPat = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

function chkSubmit6(){
	var frm = document.forms.form6;
	var url = frm.url.value.trim();
	var email = frm.email.value.trim();

	document.getElementById("urlwarn").innerHTML = "";
	document.getElementById("emailwarn").innerHTML = "";

	//정규표현식 객체의 test() : 패턴 매칭 여부 
	if(!urlPat.test(url)) { 
		document.getElementById("urlwarn").innerHTML = " 유효하지 않은 url";
		frm.url.focus();
		return false;
	}

	if(!emailPat.test(email)){
		document.getElementById("emailwarn").innerHTML = " 잘못된 email 입니다";
		frm.email.focus();
		return false;
	}
	return true;
}
