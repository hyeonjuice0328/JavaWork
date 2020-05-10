var str1, str2, str3;

str1 = "John"
str2 = new String("John");   // 비추

console.log(str1)   // 결과 : John
console.log(str2.toString())   // 결과 : John

console.log(str1 == str2)   // 결과 : True
console.log(str1 === str2)   // 결과 : False

 // 문자의 개수
console.log(str1.length);   // 결과 : 4 

str2 = "Hello Java Web FrameWork";
console.log(str2);  // 결과 : Hello Java Web FrameWork


// 문자열 리터럴 중간을 끊어서 작성할 경우..\역슬레시로 이어주기
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);


// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 \nindexOf(), lastIndexOf(), search()");

str1 = "Please locate where 'locate' occurs!";
console.log(str1.indexOf("locate"))    // 결과 : 7 
// 
console.log(str1.lastIndexOf("locate"))    // 결과 : 21
console.log(str1.indexOf("John"))    // 결과 : -1

// 10번재부터 검색시작
console.log(str1.indexOf("locate", 10))    // 결과 : 21
console.log(str1.indexOf("locate", 25))    // 결과 : -1

// search() : 문자열 안에서 문자열 찾기
console.log(str1.search("locate"))    // 결과 : 7


// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다
// 	indexOf() : regexp (정규편식) 사용 불가




//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)


console.log("문자열 추출\nslice(), substring(), substr()");



str1 = "Apple, Banana, Kiwi";

// 7부터 13전까지
console.log(str1.slice(7, 13));  // 결과 : Banana
console.log(str1.slice(-12, -6))  // 결과 : Banana
// 7부터 끝까지
console.log(str1.slice(7));  // 결과 : Banana, Kiwi  
console.log(str1.slice(-12));  // 결과 : Banana, Kiwi 

// slice()와 유사하나 음수인덱싱 지원안함.
console.log(str1.substring(7, 13));  // 결과 : Banana
// 7부터 끝까지
console.log(str1.substring(7));  // 결과 : Banana, Kiwi   
// 7부터 6글자
console.log(str1.substr(7, 6));  // 결과 : Banana
// 7부터 끝까지
console.log(str1.substr(7));  // 결과 : Banana, Kiwi  


// 문자열 치환
// replace() : 치환한 결과 문자열 리턴, 정규표현식 사용 가능
// 기본적으로 첫번째 '매칭된 문자열 만 치환
console.log("문자열 치환 replace()");


str1 = "Please visit Japan!";

// 원본 str1 은 변경되지 않는다.
console.log(str1.replace("Japan", "Korea"));// 결과: Please visit Korea!
// 대소문자 구분한다. Japan 과 JAPAN 은 같지 않다. 그래서 치환 X
console.log(str1.replace("JAPAN", "Korea"));// 결과: Please visit Japan!
// 정규표현식 /JAPAN/i   i 의 역할 : 대소문자 구분없이 치환
console.log(str1.replace(/JAPAN/i, "Korea"));// 결과: Please visit Korea!


str2 = "Please visit Japan! Go Japan";
console.log(str2.replace("Japan", "Korea"));// 결과: Please visit Korea! Go Japan
// g : global match 모두 치환 
console.log(str2.replace(/Japan/g, "Korea"));// 결과: Please visit Korea! Go Korea


str3 = "Hello World!";
console.log(str3.toUpperCase());//결과: HELLO WORLD!
console.log(str3.toLowerCase());//결과: hello world!

// concat() : 문자열 이어 붙이기
str1 = "Hello"; str2 = "World";
console.log(str1 + " " + str2);//결과: Hello World
console.log(str1.concat(" ", str2));//결과: Hello World

// trim() : 좌우 공백 제거
str1 = "       Hello World!        ";
console.log(`str1 = [${str1}]`);//결과 : str1 = [       Hello World!        ]
str2 = str1.trim();
console.log(`str2 = [${str2}]`);//결과 : str2 = [Hello World!]


