package 반복제어문1.형성평가03;

/*
 * 0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 
 * 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
(평균은 반올림하여 소수 첫째자리까지 출력한다.)
입력 예
55 100 48 36 0 101
출력 예
sum : 239
avg : 47.8
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		int cnt = 0;
		double avg = 0;

		while (true) {
			num = sc.nextInt();
			if (num < 0 || num >= 101)
				break;
			else {
				sum += num;
				cnt++;
				avg = sum / (float)cnt;
			}
		}
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f", avg);
	}

}
