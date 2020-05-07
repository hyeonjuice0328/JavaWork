// JAVA, C 언어와 구조 동일

a = 100

if(a + 1 > 100){
    let a = 10;
    console.log('if 안에 a 값은', a); // 결과 10
}

// Falsy 로 평가될때!
// false, 0, '', null, undefine, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

function print(data) {
    if(data){ // 참 거짓 판정
        console.log(data, typeof data, '--Truthy');
    } else {
        console.log(data, typeof data, '--Falsy');
    }
}

// if 문 매개변수로 들어가는 .. 
print(true)
print(false)
print(100)
print(0) // 0 이면 false
print(-1) // T
print('hello') // T
print("") // 비어있는 문자열 F
print([10, 20, 30]) // T
print([]) // T, 파이썬과 다르다. 
print({'name' : 'Johm', 'age':32}) // T
print({}) // T, 파이썬과 다르다.
print(null) // F
print(undefined) // F
print(NaN) // F
console.log(100/0) // Infinity
print(100/0) // T

print() // 호출시 전달인자 없으면 undefined값으로 동작

console.log()
// Falsy값에 !(not) 결과 > true
console.log(!undefined)
console.log(!null)
console.log(!0)

// Truthy 값에 !(not) 결과 > false
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10, 20, 30])
console.log(![])
console.log(!{})

// Truthy, Falsy 판정결과--> boolean 
// 1. 삼항연산자 사용
let value = {'a' : 100}
let isTrue = value ? true : false;
console.log('isTrue =', isTrue, typeof isTrue)

// 2. !! 사용하면 가능!
isTrue = !!value;
console.log('isTrue =', isTrue, typeof isTrue)

console.log() // 줄바꿈

function printName(person){
    console.log('이름은', person.name) //undefined 에 대한 name 은 없음 > error
}
//오브젝트 생성
let myBrother = {name: "John"}

printName(myBrother)
printName() // undefined //undefined 에 대한 name 은 없음 > error

// 따라서 함수 재정의 / 매개변수 체크 필요
function printName(person){
    // 매개변수 null check
    //if(person === undefined || person === null) return;
    if(!person) return; // 간단하게 해결

    console.log('이름은', person.name)
}

printName(myBrother);
printName();