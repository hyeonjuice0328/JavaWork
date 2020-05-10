// var, let, const

var a = 100;
console.log('a=', a)
a = 200
console.log('a=', a)

var a = 500; // 중복선언 가능
console.log('a=', a)

// ES6 부터 let, const 로 변수 상수 지정 가능
let value = 177;
console.log('value=', value);
value = 555;
console.log('value=', value);

//let value = 277;
// 중복선언불가, 동일이름변수 let 으로 선언불가.

//상수 선언
const b = 1;
console.log('b=', b)
//b = 2; -- 오류

console.log('b=', b)

//-------------------------------------------------
// var 는 오늘날 JS 환경에서 권장하지 않는다.(사용은 가능)
// var 와 let
// IE9, IE10  와 같은 구형 브라우저에서는
//  let, const 를 사용 못함.

// 개발 단계에서는 '바벨' 등을 사용하여
// 우리가 개발한 코드가 구형 브라우저 에서 동작케 함.

let c;
// let 초기화 따로 해도 가능 
// 초기화와 선언을 같이 하지 않아도 된다.
c = 100;

// ` : back tick 
console.log(`c = ${c}`);
//${c} : 위에서 선언한 c 값을 의미
// template literal (ES6 <= : ES6 이상에서 사용가능)

// 데이터 타입들
let value2 = 100; // number 타입

console.log(value2, typeof value2); // 변수 타입 출력

// JS 는 대입되는 값에 따라 '타입' 이 바뀐다.
value2 = 'hello'; // String 타입
console.log(value2, typeof value2); 
// single qu '' 가능 double qu "" 도 가능


