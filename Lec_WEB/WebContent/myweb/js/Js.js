

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
