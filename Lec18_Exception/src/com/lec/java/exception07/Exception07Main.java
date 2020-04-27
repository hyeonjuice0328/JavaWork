package com.lec.java.exception07;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 	나만의 Exception -> CumtomException
 */
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : ScoreException 을 throws 하는 메소드 만들기
	public static int inputScore() throws ScoreException { // inputScore()메소드
		int score = sc.nextInt();
		sc.nextLine();

		// 정수가 음수이거나 100점이 넘어가면 안된다.
		// 그 이외의 상황이 발생하면 ScoreException 실행할 수 있도록 설정
		if (score < 0 || score > 100) { // 예외 조건
			// ScoreException ex = new ScoreException();
			// 내가 만든 예외 클래스 초기화
			ScoreException ex = new ScoreException(score + "값은 유효한 점수가 아닙니다.");

			throw ex; // 예외 객체 throw!! - 반드시 throws 해주기!!
		}

		return score;
	} // end inputScore()

	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");

		System.out.println();

		// TODO : ScoreException 을 catch 해보자
		int i = 0;
		while (i < 5) {
			try {
				System.out.println("국어 점수 입력:");
				int kor = inputScore();
				System.out.println("kor = " + kor);

//				System.out.println("영어 점수 입력:");
//				int eng = inputScore();
//				System.out.println("eng = " + eng);
				i++; //정상적으로 입력 받았을 때 값을 1 더해준다. 
				
			} catch (ScoreException ex) {
				System.out.println(ex.getMessage());
				System.out.println("다시 입력하세요.");
			} catch (InputMismatchException ex) {
				System.out.println("적절하지 않은 입력값입니다.");
				sc.nextLine(); // 버퍼제거 
			}
		}

		sc.close();

		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main
