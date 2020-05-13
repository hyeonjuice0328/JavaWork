// 이름 없는 함수 만들어서 호출
(function(){
    // 바다
    var $waterFront = $("#water-front");
    var $waterBack = $("#water-back");

    // loopSea 함수 호출
    (function loopSea(){
        $waterFront
            .animate({'botton':'-65px', 'left':'-30px'},500)
            .animate({'botton':'-60px', 'left':'-25px'},500);
        $waterBack
            .animate({'botton':'-15px', 'left':'-20px'},500)
            .animate({'botton':'-10px', 'left':'-25px'},500);
        $.when($waterFront, $waterBack).done(loopSea);
    })();


})()