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

    // 구름
    var $cloud1 = $('#cloud-group-1');
    var $cloud2 = $('#cloud-group-2');

    (function loopCloud(){
        $cloud1
            .animate({'left':'-720px'}, 10000)
            .animate({'left':'0px'}, 0);
        $cloud2
            .animate({'left':'0px'}, 10000)
            .animate({'left':'720px'}, 0, loopCloud);
    })();

    // 보트
    var $boat = $('#boat');
    var $questionMark = $('#question-mark');
    var $title1 = $('#title1');
    var $title2 = $('#title2');
    var $form = $('#form');

    //최초 시작값
    $boat.css({'left':'-220px'});
    // 최초에는 투명도 주어서 안보이게
    $questionMark.css({'opacity':0}); 
    $title1.css({'opacity':0});
    $title2.css({'opacity':0});
    $form.css({'left':'370px'});

    //방법1 : animate()+callback
    // $boat.animate({'left':'20px'},2000,function(){
    //     loopBoat();
    //     $questionMark.delay(500).animate({'opacity':1},1000,function(){
    //         $title1.animate({'opacity':1},1000,function(){
    //             $title2.animate({'opacity':1},1000, function(){
    //                 $form.animate({'left':0},1500);
    //             });// end title2
    //         }); // end title1
    //     }); //  end questionMark
    // }); // end boat ani

    //방법2 : $when() .then() 사용
    // $.when( $boat.animate({'left':'20px'},2000))
    // .then(function(){
    //     return loopBoat();
    // })
    // .then(function(){
    //    return $questionMark.delay(500).animate({'opacity':1},1000);
    // })
    // .then(function(){
    //     return  $title1.delay(1000).animate({'opacity':1},1000);
    // })
    // .then(function(){
    //     return $title2.delay(1500).animate({'opacity':1},1000);
    // })
    // .then(function(){
    //     return $form.delay(2000).animate({'left':0},1500);
    // });

    //방법3
    // $.when( $boat.animate({'left':'20px'},2000))
    // .then(function(){
    //     return loopBoat();
    // })
    // .then(function(){
    //    return $.when($questionMark.animate({'opacity':1},1000));
    // })
    // .then(function(){
    //     return  $.when($title1.animate({'opacity':1},1000));
    // })
    // .then(function(){
    //     return $.when($title2.animate({'opacity':1},1000));
    // })
    // .then(function(){
    //     return $form.animate({'left':0}), 500, reload;
    // });// end boat

    //방법4
    //: 단일 애니메이션의 연속인 경우 Promise() 만으로 가능하다.
    $boat.animate({'left':'20px'},2000).promise()
        .then(function(){
            loopBoat();
            return $questionMark.delay(500).animate({'opacity':1},1000).promise();
        })
        .then(function(){
            return  $title1.delay(500).animate({'opacity':1},1000).promise();
        })
        .then(function(){
            return  $title1.delay(500).animate({'opacity':1},1000).promise();
        })
        .then(function(){
            return $title2.delay(500).animate({'opacity':1},1000).promise();
        })
        .done(function(){
            $form.delay(500).animate({'left':0},1500);
        })
    ;


    function loopBoat(){
        $boat
            .animate({'bottom':'10px'},500)
            .animate({'bottom':'25px'},500,loopBoat);
    }

    function reload(){
        // 5초 뒤에 이 함수 실행..
        setTimeout(function(){
            location.reload();
        }, 5000);
    }
})()