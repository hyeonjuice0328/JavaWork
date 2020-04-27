package com.lec.java.array11;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("for와 enhanced for의 차이점");
		
		int [] arr1 = {10, 20, 30, 40, 50};
		
		System.out.println("증가 전");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		//배열의 원소를 +1씩 증가 시키기 
		System.out.println("\n증가 후");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] +=1; // arr1[i]++ , arr1[i] = arr1[i]+1 결국 모두 같은 값 
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println("\nenhanced-for문 증가 후");
		int [] arr2 = {10, 20, 30, 40, 50};
		for(int num : arr2) {
			num += 1;
		} //end for(num)
		for(int num : arr2) {
			System.out.print(num + " ");
		} //end sysout
		System.out.println();
		// enhanced-for문은 사본으로 (복사해서) 사용하기 때문에 증가를 할 수 없다. 원본에 접근X
	} // end main()

} // end class Array11Main









