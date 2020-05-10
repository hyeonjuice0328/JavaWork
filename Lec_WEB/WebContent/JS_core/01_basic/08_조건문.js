// JAVA, C 언어와 구조 동일

a = 100

if(a + 1 > 100){
    let a = 10;
    console.log('if 안에 a 값은', a); // 결과 10
}
console.log()
// Falsy 로 평가될때!
// false, 0, '', null, undefine, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

// 참 거짓 판정할 print 함수 
function print(data) {
    if(data){ 
        console.log(data, typeof data, '--Truthy');
    } else {
        console.log(data, typeof data, '--Falsy');
    }
}

// if 문 매개변수로 들어가는 .. 
print(true) // 결과 : true boolean --Truthy
print(false) // 결과 : false boolean --Falsy
print(100) // 결과 : 100 number --Truthy
// 0 이면 false
print(0)  // 결과 : 0 number --Falsy
print(-1) // 결과 : -1 number --Truthy
print('hello') // 결과 : hello string --Truthy
// 비어있는 문자열 F
print("") // 결과 :  string --Falsy
print([10, 20, 30]) // 결과 : [ 10, 20, 30 ] object --Truthy
// T, 파이썬과 다르다.
print([]) // 결과 : [] object --Truthy
print({'name' : 'Johm', 'age':32}) // 결과 : { name: 'Johm', age: 32 } object --Truthy
// T, 파이썬과 다르다. 
print({}) // 결과 : {} object --Truthy
print(null) // 결과 : null object --Falsy
print(undefined) // 결과 : undefined undefined --Falsy
print(NaN) // 결과 : NaN number --Falsy
console.log(100/0) // 결과 : Infinity
print(100/0) // 결과 : Infinity number --Truthy
// 호출시 전달인자 없으면 undefined값으로 동작
print() // 결과 : undefined undefined --Falsy

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
console.log('isTrue =', isTrue, typeof isTrue) // 결과 : isTrue = true boolean

// 2. !! 사용하면 가능!
isTrue = !!value;
console.log('isTrue =', isTrue, typeof isTrue) // 결과 : isTrue = true boolean

console.log() // 줄바꿈

function printName(person){
    console.log('이름은', person.name) }//undefined 에 대한 name 은 없음 > error

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
