package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt(); // 입력받을 값을 저장할 변수 i
		int count = 1; // 숫자들 시작 숫자 1 
		int sum = 0; // 숫자들의 합 
		while (count <= i) { // while문 1부터 입력받은 숫자까지 반복해서 출력
			sum += count; // sum 에 하나씩 뽑아서 합
			count++; 
			sc.close();
		}
		System.out.println(sum);
	}

}
