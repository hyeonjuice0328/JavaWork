// 변수의 유효범위
// scope

// const, let 의 유효범위
//  ==> Block Scope
//    { ... }

// 블럭
{
    const name = 'Mark'
    // 블럭 안에서만 사용가능
    console.log(`name = ${name}`) 
}
// 블럭 밖에서 사용하게 되면 에러 발생
//console.log(`name = ${name}`)

{
    //console.log('name =', name)
    //ReferenceError: Cannot access 'name' before initialization
    //초기화가 안되어있다는 에러
    const name = 'Mark'
}

{
    console.log('value1 = ', value1);
    var value1 = 200;

//    console.log('value2 = ', value2);
}

// Hoisting
// https://developer.mozilla.org/ko/docs/Glossary/Hoisting

// 이러한 현상을 hoisting 이라 하는데
// hoisting 현상은 함수에서만 발생하는게 아니다.

// hoising 
// 아래에 있는 선언을(만) 끌어올린다.

// hoising 때문에 동작의 오류처럼 보이는 증상 겪게 됨

// hoising 현상은 처음부터 있었으나
// 용어 자체는 ES2015 및 그 이전에는 사용되지 않음

{
    console.log(`nick=${nick}`); // 2.가 hoisting 됨

    nick = 'Mighty'; // 1.
    console.log(`nick=${nick}`); // 1.
    var nick = 'iron'; // 2.

    // 1. nick 과 2. nick 은 변수 scope 가 다르다.
}
    age = 6;
    age++;
    console.log('1.age =' , age)
{

    console.log(`2.age = ${age}`) 
    //브럭 바깥쪽 scope 의 변수 사용 가능.
    age = 30
    console.log(`3.age = ${age}`)
    //var age; // var 는 hoisting 발생
    //let age; // let 은 hoisting이 발생하지 않는다.
}
console.log(`4.age = ${age}`)

