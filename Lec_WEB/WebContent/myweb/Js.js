

// (function(){



// // 로그인 버튼
// var $loginBtn = $('#login');
// //가입 버튼
// var $joinBtn = $('#join');
// //카트 버튼
// var $cartBtn = $('#cart');

// var $modal = $('#loginmodal');
// var $close = $('#close');


// $loginBtn.click(function(){
//     $modal.css("display","block");
// })

// $close.click(function(){
//     $modal.css("display","none");
// })

// $(window).click(function(event){
//     if(event.target == $modal){
// 		$modal.css("display","none");
// 	}
// })


// }) // end 이름없는 함수

// var loginBtn = document.getElementById("login");
// var modal = document.getElementById("id01");
// var close = document.getElementsByClassName("close")[0];

// loginBtn.onclick = function(){
// 	modal.style.display = "block";
// }

// close.onclick = function(){
// 	modal.style.display = "none";
// }

// window.onclick = function(event){
// 	if(event.target == modal){
// 		modal.style.display = "none";
// 	}
// }


// alertbanner shippingbanner(jquery)
var $abanner = $('#alertbanner');
var $sbanner = $('#shippingbanner');
var $cbanner = $('#cartbanner');

//최초 시작값
$abanner.css({'top':'-50px'});
$sbanner.css({'top':'-100px'});

$abanner.animate({'top':'1px'},500,function(){
    $sbanner.animate({'top':'1px'},600);
});

// 로그인 모달
var loginBtn = document.getElementById("login");
var modal = document.getElementById("id01");
var close = document.getElementsByClassName("close")[0];

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