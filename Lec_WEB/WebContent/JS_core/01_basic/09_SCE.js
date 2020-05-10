// 논리 연산자
// && and 연산자
// || or 연산자
// ! not 연산자

// 논리연산자를 이용한 조건문 실행
// Short Circuit Evaluation

// 표현식1 && 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식1
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식2

// 표현식1 || 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식2
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식1

console.log(true && true) // 결과값 : true
console.log(true && false) // 결과값 : false

let a = 100
console.log(a > 10 || a + 10 < 10) // 결과값 : true
console.log(a < 10 || a + 10 < 10) // 결과값 : false

console.log(a > 10 && a + 10 < 10) // 결과값 : false
console.log(a < 10 && a + 10 < 10) // 결과값 : false

// 왼쪽이 결과값 결과는 Hello
console.log("Hello" || "world") // 결과값 : Hello
console.log(0 || "world") // 결과값 : world

// && 는 좌측이 참이면 무조건 우측값이 결과값으로 나온다.
console.log(5 && 100)  // 결과값 : 100
console.log(0 && 100)  // 결과값 : 0
// && 는 좌측이 거짓이면 좌측값이 결과값
console.log(null && 'hello')  // 결과값 : null

let n = 15;
(n % 5 == 0) && console.log('5의 배수입니다')
 // 결과값 : 5의 배수입니다

n = 7;
(n % 5 === 0) || console.log('5의 배수가 아닙니다')
 // 결과값 : 5의 배수가 아닙니다

 