// function 키워드로 만든다.

// function 함수이름 (매개변수 ... )
// 이런식으로 정의하기 보다는 19번줄부터 있는 식으로 정의하는 것을 선호한다.
function add(a, b){
    return a + b;
} 

var sum = add(1, 2);
console.log("sum =", sum);

console.log(typeof add);
console.log(add);

var add = function(a, b){
    return a + b;
}

var sub = function(a, b){ 
    // 이름없는 (빼기 동작으로하는)함수를 sub 라는 변수에 담아 사용 
    return a - b;
}
console.log(sub(10, 3))

let mul = function(a, b){return a * b;}
console.log(mul(4,5))

let bbb = mul;  // 이제 bbb 도 함수다!
console.log(bbb(100, 2))

var arr = [add, sub, mul];

console.log(arr[0](10,20))
console.log(arr[1](10,20))
console.log(arr[2](10,20))
