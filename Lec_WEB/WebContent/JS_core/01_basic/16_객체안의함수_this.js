const cat = {
    name : "야옹이",
    sound : '야옹야옹',

    // 객체 안의 함수 정의하는 다양한 방법들 

    // 방법1 : 함수 전체는 say1 에 대입 say1 을 정의
    say1: function aaa(){
        console.log(this.sound); // this 는 함수가 위치한(소유한) 객체
    },

    // 방법2 : 이름없는 함수
    say2 : function(){
        console.log(this.sound);
    },

    // 방법3 : 최신 JS 방식 (name-value 쌍으로 만들지 않아도 가능)
    say3() {
        console.log(this.sound);
    },

    // 화살표 함수의 경우 .. this 가 문제가 된다.
    say4 : () => {
        console.log(this.sound);
        console.log(this);
    }
  // 이유
  // function 키워드로 만든 함수에서의 this는
  // 자기가 속해있는, 객체를 가리키는데..
  // 화살표 함수의 경우
  // this를 자기가 속해 있는 곳으로
  // 연결하지 않습니다.
  // 화살표 함수는 this 가 뭔지 모릅니다!



}

cat.say1();
cat.say2();
cat.say3();