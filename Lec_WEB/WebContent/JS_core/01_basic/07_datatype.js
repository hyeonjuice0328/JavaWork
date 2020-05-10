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
}   // 결과 : a =  null object

//---------------------------------------------------------------------------
// undefined
// 아무 값도 대입이 안된 상태
{
    let b; 
    console.log('b =', b, typeof b); //결과: b = undefined undefined

    let a = 10;
    // 다시 undefined 로 a 에 대입가능
    a = undefined; 
    console.log('a =', a, typeof a); //결과: a = undefined undefined

    a = null; b = undefined;
    // 단순 값만 비교
    if(a == b){ console.log('== 같습니다.');} 
    else { console.log('== 다릅니다');} //결과: ==같습니다.

    // 값과 타입까지 비교
    if(a === b){ console.log('=== 같습니다.');} 
    else { console.log('=== 다릅니다');} //결과: ===다릅니다.

    // ** JS 프로그래밍에 작성시 == 보다 === 를 추천
    // != 보단 !== 추천
}

//---------------------------------------------------------------------------
// number
console.log('\n<number>')
{
    const a = 37;
    console.log('a =', a, typeof a);//결과: a = 37 number
    const b = 3.14;
    console.log('b =', b, typeof b);//결과: b = 3.14 number

    const c = NaN; 
    console.log('c =', c, typeof c);//결과: c = NaN number
    
    let d = Number(123);
    console.log('d =', d, typeof d);//결과: d = 123 number

    // 문자열'123'을 number로 (자동) 형변환 되었음
    d = Number('123'); 
    console.log('d =', d, typeof d);//결과: d = 123 number
    
    // 문자는 number로 형변환 되지 않는다.
    d = Number('Mark'); 
    console.log('d =', d, typeof d);//결과: d = NaN number

    // parseInt 를 사용해서 문자열을 number 로 형변환
    d = parseInt('123'); 
    console.log('d =', d, typeof d);//결과: d = 123 number
    
    d = parseFloat('3.14');d *= 3;
    console.log('d =', d, typeof d);//결과: d = 9.42 number

    num1 = 100; num2 = '100';
    if(num1 == num2){
        console.log(`${num1} == ${num2} 같다`);
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    } // 결과 : 100 == 100 같다
    

    if(num1 === num2){
        console.log(`${num1} === ${num2} 같다`);
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    } // 결과 : 100 === 100 다르다
}

//---------------------------------------------------------------------------
// String(문자열)
// ' ' , " "
console.log('\n<string>')
{
    let a = 'Mark';
    console.log('a =', a, typeof a); // 결과 : a = Mark string
    
    a = "She's gone";
    console.log('a =', a, typeof a); // 결과 : a = She's gone string

    a = 'He says "Hello"';
    console.log('a =', a, typeof a); // 결과 : a = He says "Hello" string
    
    a = "He says \"I'm fine\"";
    console.log('a =', a, typeof a); // 결과 : a = He says "I'm fine" string

    // + 문자열 연산
    a = "Mark"
    let b = a + " Hamill";
    console.log('b =', b, typeof b); // 결과 : b = Mark Hamill string

    console.log(a * 2); // 결과 : NaN

    // 문자열 비교연산 가능!
    // 코드값 비교가능!
    if("a" > "b") { console.log('참 입니다'); } 
    else {console.log('거짓 입니다'); } // 결과 : 거짓 입니다
    
    // 문자열 비교연산 코드순 비교 ( 대문자 < 소문자)
    console.log("a">"b"); // 결과 : false
    console.log("a"<"b"); // 결과 : true
    console.log("abc"<"abd"); // 결과 : true
    console.log("AAaa">"AaAa"); // 결과 : false
}

//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용

console.log('\n<symbol>');

{
     // new 사용이 안된다. 
    const a = Symbol();
    // Symbol(매개변수)
    const b = Symbol(37); 
    const c = Symbol('Mark');
    const d = Symbol('Mark');

    console.log('a =', a, typeof a);// 결과 : a = Symbol() symbol
    console.log('b =', b, typeof b);// 결과 : b = Symbol(37) symbol
    console.log('c =', c, typeof c);// 결과 : c = Symbol(Mark) symbol
    console.log('d =', d, typeof d);// 결과 : d = Symbol(Mark) symbol

    console.log(c == d);// 결과 : false
    console.log(c === d);// 결과 : false

    //일반문자열
    let e = 'Mark', f = 'Mark';

    console.log(e == f);// 결과 : true
    console.log(e === f);// 결과 : true
}
