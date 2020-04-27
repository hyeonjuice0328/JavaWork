package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {

	// 사용자로부터 입력을 받는다. 이름 전화번호 이메일
	Scanner sc;
	PhonebookModel[] bookData = new PhonebookModel[5]; // 최대 5개만 담을 수 있는 ..

	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); // 프로그램 초기화
		app.run(); // 프로그램 구동
		app.exit(); // 프로그램 종료

	} // end main()

	// 응용프로그램을 초기화하는 메소드
	public void init() { // 스캐너 초기화
		sc = new Scanner(System.in);
	}

	// 응용프로그램을 구동하는 메소드
	public void run() {
		System.out.println("전화번호부 v1.0");

		while (true) { // 사용자로부터 입력받는거 무한히 돌아가게 ..
			showMenu(); // 메뉴 표시

			int menu = sc.nextInt(); // 메뉴 사용자로부터 입력
			sc.nextLine(); // 버퍼 비우기

			switch (menu) {
			case 1:
				System.out.println("전화번호를 입력합니다.");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출력(열람)");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			} // end switch
		} // end while

	} // end run()

	// 응용프로그램을 종료하는 메소드
	public void exit() {
		sc.close(); // 스캐너로 입력 모두 받은 후 프로그램 종료
	}

	// 전화번호부 입력하는 메소드
	public void insertPhoneBook() {

//		PhonebookModel[] bookData = new PhonebookModel[5];
		int i;
		// 전화번호부가 다 찼는지 확인
		for (i = 0; i < bookData.length; i++) {
			if (bookData[i] == null)
				break; // null값이면 배열이 비어있는 것 .. 근데 왜 break???
		} // end for
			// 다 찼으면 입력불가 처리
		if (i == bookData.length) {
			System.out.println("전화번호부가 다 찼습니다.");
			return; // 왜 return???
		}
		// 이름, 전화번호, 이메일 입력
		System.out.println("이름을 입력");
		String name = sc.nextLine();
		System.out.println("전화번호 입력");
		String phoneNum = sc.nextLine();
		System.out.println("이메일 입력");
		String email = sc.nextLine();
		// --> PhonebookModel 인스턴스 생성
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.setUid(i);
		//PhonebookModel 24번쨰 줄 this(); 로 생성자 위임을 해서 날짜는 자동으로 입력
		// 배열에 추가
		bookData[i] = pb;
		System.out.println((i+1) + "번째 전화번호부 추가 성공" );

	} // end insertPhoneBook()

	// 전화번호부 출력하는 메소드
	public void showPhoneBook() {

		// 배열 안에 저장된 전화번호부들 출력.
		int i;
		for (i = 0; i < bookData.length; i++) {
			PhonebookModel pb = bookData[i]; // 이 부분 이해가 안감..
			if(pb == null) break; // 여기두....
			
			System.out.println(pb);
		}
		System.out.println(i + " 개의 전화번호부 출력");
		
		
	}

	// 메뉴 메소드
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}

}
