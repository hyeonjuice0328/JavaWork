// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
//   .. 배열 .. 등등

//----------------------------------------------------------------------
// boolean type
// true and false
{
    const isTrue = true;
    const isFalse = false;

    console.log(`isTrue = ${isTrue}`, typeof isTrue)
    console.log(`isFalse = ${isFalse}`, typeof isFalse)

    if(isTrue){
        console.log(isTrue, '참 입니다');
    } else {
        console.log(isFalse, '거짓입니다')
    }

    //객체로 생성(new) 가능하지만 비추
    //boolean 을 new 로 만들면 오브젝트 타입이 된다.
    const a = new Boolean(false); // false 값을 갖는 boolean 객체 
    console.log('a = ', a, typeof a);

    if(a){ // 객체 생성까지는 가능하지만 조건식에서 false 가 '참'으로 판정난다.
        console.log(a, '참입니다');
    } else {
        console.log(a, '거짓입니다')
    }

    //new를 사용하지 않고 boolean 만들기 
    const b = Boolean(false); // Boolean 함수!! 
    console.log('b =', b, typeof b)

    if(b){ 
    console.log(b, '참입니다');
} else {
    console.log(b, '거짓입니다')
}
}

//---------------------------------------------------------------------------
// null
// 값이 없는 object
console.log('\n<null>');
{
    const a = null;
    console.log('a = ', a, typeof a);

}

//---------------------------------------------------------------------------
// undefined
// 아무 값도 대입이 안된 상태
{
    let b; // 아무값도 대입 안된 상태 , undefined
    console.log('b =', b, typeof b);

    let a = 10;
    a = undefined; // 다시 undefined 로 대입가능
    console.log('a =', a, typeof a);

    a = null; b = undefined;
    if(a == b){ // 단순히 값만 비교
        console.log('== 같습니다.');
    } else { 
        console.log('== 다릅니다');
    }

    if(a === b){ // 값과 타입까지 비교
        console.log('=== 같습니다.');
    } else { 
        console.log('=== 다릅니다');
    }
    // ** JS 프로그래밍에 작성시 == 보다 === 를 추천
    // != 보단 !== 추천

}

//---------------------------------------------------------------------------
// number
console.log('\n<number>')
{
    // 실수 정수 모두 number type
    const a = 37;
    console.log('a =', a, typeof a);
    const b = 3.14;
    console.log('b =', b, typeof b);

    const c = NaN; // Not a Number 의 약자 
    console.log('c =', c, typeof c);
    
    let d = Number(123);
    console.log('d =', d, typeof d); // number
    
    d = Number('123'); // number로 형변환 되었음
    console.log('d =', d, typeof d); 
    
    d = Number('Mark'); // number로 형변환 안됨
    console.log('d =', d, typeof d); // NaN number 

    d = parseInt('123'); // number 로 형변환
    console.log('d =', d, typeof d);

    d = parseInt('Alice'); 
    console.log('d =', d, typeof d); // NaN number 
    
    d = parseFloat('3.14');
    d *= 2;
    console.log('d =', d, typeof d);

    d = parseInt('3.14'); 
    console.log('d =', d, typeof d);
    
    d = parseFloat('300'); 
    console.log('d =', d, typeof d);

    num1 = 100; num2 = '100';
    if(num1 == num2){
        console.log(`${num1} == ${num2} 같다`);
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    }
    
    if(num1 === num2){
        console.log(`${num1} === ${num2} 같다`);
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    }
}

//---------------------------------------------------------------------------
// String(문자열)
// ' ' , " "
console.log('\n<string>')
{
    let a = 'Mark';
    console.log('a =', a, typeof a);
    
    a = "She's gone";
    console.log('a =', a, typeof a);

    a = 'He says "Hello"';
    console.log('a =', a, typeof a);
    
    a = "He says \"I'm fine\"";
    console.log('a =', a, typeof a);

    // + 문자열 연산
    a = "Mark"
    let b = a + " Hamill";
    console.log('b =', b, typeof b);

    console.log(a * 2); // NaN

    // 문자열 비교연산 가능!
    // 코드값 비교 
    if("a" > "b") {
        console.log('참 입니다');
    } else {
        console.log('거짓 입니다');
    }
    
    // 문자열 비교연산 코드순 비교
    console.log("a">"b");
    console.log("a"<"b");
    console.log("abc"<"abd");
    console.log("AAaa">"AaAa"); // 대문자 < 소문자
}

//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용

console.log('\n<symbol>');

{
    const a = Symbol(); // new 사용이 안됨
    const b = Symbol(37); // Symbol(매개변수)
    const c = Symbol('Mark');
    const d = Symbol('Mark');
    // c 와 d 는 같은 것이 아니다. 
    // 고유한 symbol 객체로 만들어 진다.

    console.log('a =', a, typeof a);
    console.log('b =', b, typeof b);
    console.log('c =', c, typeof c);
    console.log('d =', d, typeof d);

    console.log(c == d);
    console.log(c === d);

    //일반문자열
    let e = 'Mark', f = 'Mark';

    console.log(e == f);
    console.log(e === f);
}
