package phonebook03.ex;

import java.util.InputMismatchException;
import java.util.Scanner;
//VIEW 객체
//사용자와의 입출력 담당(UI, ...)

public class PhonebookMain {

	// 사용자로부터 입력을 받는다. 이름 전화번호 이메일
	private Scanner sc;
	private PhonebookManager pbCtrl; // CONTROLLER 객체

	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); // 프로그램 초기화
		app.run(); // 프로그램 구동
		app.exit(); // 프로그램 종료

	} // end main()

	// 응용프로그램을 초기화하는 메소드
	public void init() { // 스캐너 초기화
		sc = new Scanner(System.in);
		pbCtrl = PhonebookManager.getInstance(); // CONTROLLER 생성(singleton design)
	}

	// 응용프로그램을 구동하는 메소드
	public void run() {
		System.out.println(Pb.VERSION);

		int menu;
		
		while (true) { // 사용자로부터 입력받는거 무한히 돌아가게 ..
			showMenu(); // 메뉴 표시
			try {
				menu = sc.nextInt(); // 메뉴 사용자로부터 입력
				sc.nextLine(); // 버퍼 비우기
				
				switch (menu) {
				case Menu.MENU_INSERT:
					insertPhoneBook();
					break;
				case Menu.MENU_LIST:
					listPhonebook();
					break;
				case Menu.MENU_DELETE:
					deletePhonebook();
					break;
				case Menu.MENU_UPDATE:
					updatePhonebook();
					break;
				case Menu.MENU_QUIT:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
				} // end switch
			} catch (PhonebookException ex) {
				System.out.println(ex.getMessage()); // 오버라이딩 한 getMessage()
			} catch (InputMismatchException ex) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
		} // end while
	} // end run()

	// 응용프로그램을 종료하는 메소드
	public void exit() {
		sc.close(); // 스캐너로 입력 모두 받은 후 프로그램 종료
	}

	// 전화번호부 입력하는 메소드
	public void insertPhoneBook() {
		// VIEW 역할 : 사용자 입출력
		System.out.println("--- 입력 메뉴 ---");

		// 이름, 전화번호, 이메일 입력
		System.out.println("이름을 입력");
		String name = sc.nextLine();

		System.out.println("전화번호 입력");
		String phoneNum = sc.nextLine();

		System.out.println("메모 입력");
		String memo = sc.nextLine();

		// CONTROLLER에 연결
		int result = pbCtrl.insert(name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 입력 성공");
	} // end insertPhoneBook()

	// 전화번호부 전체 열람
	public void listPhonebook() {
		// CONTROLLER 연결 , interface에 있던 메소드 사용
		PhonebookModel[] data = pbCtrl.selectAll();
		// VIEW 역할 : 사용자 입출력
		System.out.println("총" + data.length + " 명의 전화번호 출력");
		for (PhonebookModel e : data) {
			System.out.println(e);
		} // end for
	} // end listPhonebook()

	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW : 사용자 입출력
		System.out.println("--- 수정 메뉴 ---");
		System.out.println("수정할 번호는 입력:");
		int uid = sc.nextInt(); // uid 입력 받는 곳
		sc.nextLine();
		// CONTROLLER 연결
		if (pbCtrl.selectByUid(uid) == null) { // uid를 못찾은 경우
			System.out.println("존재하지 않는 uid : " + uid);
			return;
		}

		// 이름, 전화번호, 이메일 입력
		System.out.println("이름을 입력");
		String name = sc.nextLine();

		System.out.println("전화번호 입력");
		String phoneNum = sc.nextLine();

		System.out.println("메모 입력");
		String memo = sc.nextLine();

		// CONTROLLER 연결

		int result = pbCtrl.updateByUid(uid, name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 수정 성공");
	} // end updatePhonebook()

	// 전화번호부 삭제
	public void deletePhonebook() {
		// VIEW :사용자 입출력
		System.out.println("--- 삭제 메뉴 ---");

		System.out.println("삭제할 번호 입력:");
		int uid = sc.nextInt();
		sc.nextLine();

		// CONTROLLER
//		if(pbCtrl.selectByUid(uid) == null) { //uid를 못찾은 경우
//			System.out.println("존재하지 않는 uid F: " + uid);
//			return;
//		}

		int result = pbCtrl.deleteByUid(uid);

		System.out.println(result + " 개의 전화번호 삭제 성공");
	} // end deletePhonebook()

	// 메뉴 메소드
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[0] 종료");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 수정");
		System.out.println("[4] 삭제");
		System.out.println("------------------");
		System.out.print("선택: ");
	}

} // end class
