// 배열 생성 방법

// 방법1 : [ ] 사용
var points = [40, 100, 1, 5, 25, 10];
var fruits = ['Banana', 'Orange', 'Apple', 'Mango']
console.log('points =', points, typeof points);
// 결과 : points = [ 40, 100, 1, 5, 25, 10 ] object


// 방법2 : new 사용
var cars = new Array("Saab", "Volvo", "BMW");   // 비추
console.log('cars =', cars, typeof cars);
// 결과 : cars = [ 'Saab', 'Volvo', 'BMW' ] object
console.log('fruits =', fruits.toString());
// 결과 : fruits = Banana,Orange,Apple,Mango


// JS 에선 object 의 property 접근 회수를 줄이는 게 성능에 유리.
console.log()
for(i = 0; i < cars.length; i++){
    console.log(cars[i])}
    // 결과 : Saab
    //        Volvo
    //        BMW 

console.log()
//성능면에서 우의 : cars.length 에 한번만 접근
var length = cars.length; 
for(i = 0; i < length; i++){
    console.log(cars[i])}
    // 결과 : Saab
    //        Volvo
    //        BMW 

console.log()

// 객체의 property -> index
// for ~ in : 객체(object) 에 대해 사용, property 
for(x in cars){  // value 가 아닌 index 가 나옴.
    console.log('x = ', x)}
    // 결과 : x = 0
    //        x = 1
    //        x = 2

console.log()
// for ~ of  : ES6부터 사용,  iterable 한 객체에 대해 사용
for(x of cars){
    console.log('x =', x)}
    // 결과 : x = Saab
    //        x = Volvo
    //        x = BMW 

console.log()
// 배열.forEach(함수)
// 배열 원소 하나하나 뽑아내면서 함수 호출
var myFunction = function(value){
    console.log(value);}
    // 결과 : x = Saab
    //        x = Volvo
    //        x = BMW 
cars.forEach(myFunction);
    // 결과 : Saab
    //        Volvo
    //        BMW 


// 배열원소 추가
console.log()
fruits[fruits.length] = 'Melon';
console.log(fruits);

fruits.push('Lemon');
console.log(fruits);

console.log()

// 주어진 변수가 배열인지 아닌지 판단
// typeof 만으로는 알수 없다.

// 1. isArray() :  ES5.1 부터 지원.
console.log(Array.isArray(fruits)); // 결과 : true

// 2. 구 브라우저에서 판단하려면 함수만들어서 운영
function isArray(x){
    return x.constructor.toString().indexOf("Array") > -1;
}
console.log(isArray(fruits)); // 결과 : true

// 3. instanceof 연산자
console.log(fruits instanceof Array); // 결과 : true


//-----------------------------------------------------
// join()
// 배열의 원소들을 주어진 문자열로 묶어서 하나의 문자열로 리턴
console.log(cars.join("**")) // 결과 : Saab**Volvo**BMW
console.log([2020, 5, 7].join("/")) // 결과 : 2020/5/7

console.log();
// push() : 배열끝 원소 추가
// pop() : 배열 끝 원소 추출
// shift() : 배열 첫 원소 추출
// unshift() : 배열앞에 원소 추가 + 새로운 length 리턴
console.log(fruits.toString()); // 결과 : Banana,Orange,Apple,Mango,Melon,Lemon
console.log(fruits.pop()); // 결과 : Lemon
console.log(fruits.toString()); // 결과 : Banana,Orange,Apple,Mango,Melon
console.log(fruits.shift()); // 결과 : Banana
console.log(fruits.toString()); // 결과 : Orange,Apple,Mango,Melon
console.log(fruits.unshift('Grape')); // 결과 : 5
// 배열앞에 추가, 새 lenth 리턴

console.log(fruits.toString()); // 결과 : Grape,Orange,Apple,Mango,Melon

console.log()

// splicing(삽입될 데이터 위치, 삭제될 데이터 개수, 삽입될 데이터 들)
fruits.splice(2, 0, "Kiwi", "AppleMango");
console.log(fruits.toString());//결과:Grape,Orange,Kiwi,AppleMango,Apple,Mango,Melon

fruits.splice(1, 3, "Durian");
console.log(fruits.toString());//결과:Grape,Durian,Apple,Mango,Melon

// concat() : 원본 변화 시키지 않는다.
console.log(fruits.concat(['Lemon', "Banana"]));// 결과 : [
                                                //     'Grape',  'Durian',
                                                //     'Apple',  'Mango',
                                                //     'Melon',  'Lemon',
                                                //     'Banana'
                                                //   ]
console.log(fruits.toString());//결과 : Grape,Durian,Apple,Mango,Melon

// 원본 변화(덮어쓰기)
fruits = fruits.concat(['Lemon', "Banana"]) 
console.log(fruits.toString());//결과 : Grape,Durian,Apple,Mango,Melon,Lemon,Banana

// 배열 데이터 중간을 삭제 하려면??
// 배열 1부터 3개 삭제
fruits.splice(1, 3); 
console.log(fruits.toString())//결과 : Grape,Melon,Lemon,Banana

// slice()
// 배열의 일부분만 추출, 원본에는 영향 안줌
// 1부터 3전까지
console.log(fruits.slice(1, 3))//결과 : [ 'Melon', 'Lemon' ]
// 1부터 끝까지
console.log(fruits.slice(1))//결과 : [ 'Melon', 'Lemon', 'Banana' ]

// 배열의 원소는 어떠한 타입이어도 가능
var arr = [10, 3.14, 'hello', null, undefined]

// 배열의 원소가 배열일수도 있다!! --> 다차원 배열
arr = [[10, 20], [30, 40], [50, 60]]
// arr.length --> ?
// for 문 사용하여 출력
for(i = 0; i < arr.length; i++){
    console.log(arr[i].toString())} //결과 : 10,20
                                    //       30,40
                                    //       50,60