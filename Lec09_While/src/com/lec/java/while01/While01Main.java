package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;
		while(count <= 10) { //조건식이 참인동안 수행하는 것이 while문 
			System.out.println(count);
			count++;
		} // end while
		
		System.out.println();
		// 10, 9, 8, ... 1 까지 출력
		int count1 = 10; //초기식
		while(count1 >= 1) { //조건식
			System.out.println(count1);
			count1--; //증감식
		}

	} // end main()
	
} // end class While01Main









