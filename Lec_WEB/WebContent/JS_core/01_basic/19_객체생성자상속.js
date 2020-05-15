/*
객체 생성자 상속받기
예를 들어서 우리가 Cat 과 Dog 라는 새로운 객체 생성자를 만든다고 가정해봅시다. 그리고, 해당 객체 생성자들에서 Animal 의 기능을 재사용한다고 가정해봅시다. 그렇다면, 이렇게 구현 할 수 있습니다.
*/

//------------------------------------------
// 상속을 사용하지 않는 경우
{
    console.log("상속을 사용하지 않는 경우");
    function Dog(name, sound) {
      this.type = "개";
      this.name = name;
      this.sound = sound;
    }
  
    function Cat(name, sound) {
      this.type = "개";
      this.name = name;
      this.sound = sound;
    }
  
    Dog.prototype.say = function() {
      console.log(this.sound);
    };
    Cat.prototype.say = function() {
      console.log(this.sound);
    };
    let dog = new Dog("멍멍이", "멍멍");
    let cat = new Cat("야옹이", "야옹");
  
    dog.say();
    cat.say();
  
    // 위 코드를 보면 Dog, Cat 에 동일한 코드가
    // 계속해서 중복으로 사용되고 있다..
    // 이러한 경우, 상속이 필요하다
  }