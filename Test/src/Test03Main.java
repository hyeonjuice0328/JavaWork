import java.util.Scanner;

public class Test03Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("0부터6까지의 숫자를 입력하세요.");
		int num = sc.nextInt();
		
		if(num >= 0 && num <= 6 ) {
			if(num == 1) {
				System.out.println("월요일");
			}else if(num == 2) {
				System.out.println("화요일");
			}else if(num == 3) {
				System.out.println("수요일");
			}else if(num == 4) {
				System.out.println("목요일");
			}else if(num == 5) {
				System.out.println("금요일");
			}else if(num == 6) {
				System.out.println("토요일");
			}else if(num == 0) {
				System.out.println("일요일");
			}
		}else if(num < 0 || num > 6) {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		sc.close();
	}

}
