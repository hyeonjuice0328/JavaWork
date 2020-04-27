package 배열1.자가진단09;

//[문제] 10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
//[입력] 95 100 88 65 76 89 58 93 77 99
//[출력] 100 99 95 93 89 88 77 76 65 58

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int i = 0;
		int[] arr = new int[10]; // 배열 10개 자리 만들었음.
		for (int i = 0; i < arr.length; i++) { // i 가 0부터 arr.length 까지 순환
			arr[i] = sc.nextInt(); // nextInt로 사용자의 입력값 넣기
		}

		sc.close();

		for (int i = 0; i < arr.length; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
