package practice.stddev;

import java.util.Random;

// 임의정수 5개로 초기화한 정수로
// 평균, 분산, 표준편차 구하기

public class StdDev {

	public static void main(String[] args) {

		Random rand = new Random();
		int[] intArr = new int[5]; // 정수 5개 담을 배열 생성

		for (int i = 0; i < intArr.length; i++) { // intarr배열에 차례대로 입력한 정수 저장
			intArr[i] = rand.nextInt(100) + 1; // 100까지 포함된 난수
			System.out.print(intArr[i] + " "); // 난수 출력
		} // end for

//		int sum = 0; // 합
//		double dev = 0; // 분산
//		double devSum = 0; //편차제곱합
//		double avg; // 평균
//		double var; // 분산
//		double std; // 표준편차
//		System.out.println();
//		for (int i = 0; i < intArr.length; i++) {
//		sum += intArr[i];
//		avg = sum / intArr.length;
//		dev = (intArr[i] - avg);
//		devSum += Math.pow(dev, 2);
//		}
//		avg = sum / intArr.length;
//		var = devSum / intArr.length;
//		std = Math.sqrt(var);
//		
//		System.out.print("평균 : " + avg + "\n분산 : " + var + "\n표준편차 : " + std );
		System.out.println();
		System.out.println("평균 : " + calcAvg(intArr));
		System.out.printf("분산 : %.2f\n", calcVariance(intArr));
		System.out.println("표준편차 : " + Math.sqrt(calcVariance(intArr)));

	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */

	public static double calcAvg(int[] intArr) {
		double sum = 0.0;
		for (int i = 0; i < intArr.length; i++) {
			sum += intArr[i];
		}
		return sum / intArr.length;
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */

	public static double calcVariance(int[] intArr) {
		if (intArr.length < 2)
			return Double.NaN;
		double dev;
		double devSum = 0.0;
		double sum = 0.0;
		double avg;
		for (int i = 0; i < intArr.length; i++) {

			sum += intArr[i];
			avg = sum / intArr.length;
			dev = intArr[i] - avg;
			devSum += Math.pow(dev, 2);
		}
		return devSum / intArr.length;
	} // end calcVariance

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double 표준편차: 루트 분산 주어진 배열의 '표준편차' 리턴
	 */
//	public static double calcStdDev(int [] intArr) {
//		
//	}

} // end class
