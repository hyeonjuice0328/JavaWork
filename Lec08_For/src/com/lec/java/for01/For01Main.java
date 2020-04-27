package com.lec.java.for01;


/*
 * ■ 순환문(loop) : 일정 횟수를 반복하는 .. 반복문!!!
 * 	- for
 * 	- while
 * 	- do ~ while

 * 
 * ■ for 순환문 구문 반복문!!
 * 
 * for(①초기식; ②조건식; ④증감식){
 * 		③수행문;
 * 		..
 * }
 *      ①초기식 : 최초에 단한번 수행
 *      ②조건식 : true / false 결과값
 *      		위 조건식의 결과가 false 이면 for문 종료
 *      ③수행문 : 위 조건식이 true 이면  수행
 *      ④증감식 : 수행문이 끝나면 증감식 수행
 *               증감식이 끝나면 다시 ②조건식 으로.. 
 * 
 * 순환문을 작성시 내가 만드는 순환문에 대해 다음을 확실하게 인지하고 작성해야 한다.
 * 1. 몇번 순환하는 가?
 * 2. 순환중에 사용된 인덱스값의 시작값과 끝값은? 
 * 3. 순환문이 끝난뒤 인덱스값은?
 * 
 * 
    for문 작성시 TIP
	 1) n번 순환 하는 경우 (즉 횟수가 촛점인 경우)
	 for(int i = 0; i < n; i++){ .. }
	
	 2) a ~ b 까지 순환하는 경우 (즉 시작값과 끝값이 중요한 경우)
	 for(int i = a; i <= b; i++){ .. }
 */
// 지역변수 : local variable
//		  선언한 이루 그 블럭 안에서만 사용 가능. 블럭이 끝나면 소멸됨. ex) for문안에서 선언된 변수 

public class For01Main {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		
		System.out.println("Hello, Java1");
		System.out.println("Hello, Java2");
		System.out.println("Hello, Java3");
		
		System.out.println();
		
		for(int i = 1 ; i <= 3; i++) {
			System.out.println("Hello, Java"+i);
		}
		
		System.out.println();
		for(int count = 1; count <= 10; count++) {
			System.out.println("count :" + count);
		} //최초 count값은 1 마지막값은 10까지 찍힐것 / 마지막 인덱스는 11 / 10번 순환 
		
		System.out.println();
		for(int k = 10; k > 0; k--) {
			System.out.println("k = " + k);
		} //최초 k 값은 10 마지막값은 1까지 찍힐것 / 마지막 인덱스는 0 / 10번 순환 
		
		System.out.println();
		for(int k = 10; k >= 1; k--) {
			System.out.println("k = " + k);
		} //위의 반복문과 결과는 똑같다. (조건식만 변경) 순환횟수가 초점인 경우에는 (n번) -> i<n i>n 이런식
		  // 시작값과 끝값이 중요한 경우 인덱스 b까지 인경우 -> i <= b  i >= b 이런식으로 표현하는 것이 좋다. 
		
		//초기식과 증감식에 식을 여러개 사용 가능
		System.out.println();
		int i, j;
		for(i = 0, j = 10; i < j; i++,j-=2) {
			System.out.println("i:" + i + "  j:" + j);
		}
		System.out.println("for문 종료 후 \n i:"+ i +" j:" + j );
	
		for(int k = 1; k % 27 != 0; k += 4) {
			System.out.println("k = " + k);
		}
//		System.out.println("for종료 후 k = " + k); k는 지역변수 이므로 블럭 안에서만 사용가능하고 블럭을 나오면 자동 소멸 되기 때문.
//												만약에 사용 하고 싶다면 블럭 밖에서 선언 후 for문 초기식도 수정.ex. int k; k=1;
		{
			int a = 100;
			System.out.println("a = " + a);
			{
				// 안쪽의 블럭은 바깥쪽 블럭의 지역변수 사용 가능
				// 바깥블럭 지역변수의 동일 이름의 변수 사용 불가
				//int a =200;
				int b = 200;
				System.out.println("b = " + b);
			}
			// System.out.println("b = " + b); b가 안 블럭에 들어있는 지역변수라 이미 소멸
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class For01Main









