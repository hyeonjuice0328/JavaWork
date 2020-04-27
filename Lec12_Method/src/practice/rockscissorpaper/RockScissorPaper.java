package practice.rockscissorpaper;
import java.util.Scanner;

/*
	 간단한 가위, 바위, 보 게임을 만듭니다.
	(실행화면은 다음 페이지에)
	
	showMenu / inputChoice / displayChoice
	/ computeResult  메소드들을 어떻게 
	구현해볼수 있을까요? 
	
	
	main() 메소드는 오른쪽과 같이 구성하고
	변경하지 않는 상태에서
	나머지 메소드들을 구현하여 완성해보세요
	
	필요하다면 클래스의 멤버변수등을 추가해도
	좋습니다
 */
public class RockScissorPaper {

	// 멤버변수가 필요하면 작성하세요.
	
	
	
	
	// method name: showMenu
	// return: void
	// arguments: none
	// 기능: 유저가 가위/바위/보 선택할 수 있는 메뉴 출력
	public static void showMenu() {
		System.out.println("--------------------------");
		System.out.println("[1] 가위");
		System.out.println("[2] 바위");
		System.out.println("[3] 보");
		System.out.println("[0] 종료");
		System.out.println("--------------------------");
	
	} // end showMenu()
	
	
	
	// method name: getHandType
	// return: String ("가위"/"바위"/"보")
	// arguments: int choice(0, 1, 2)...이 부분 잘 모르겠어서 가위-1 바위-2 보-3
	public static String getHandType(int choice) {
		String type = "";
		if(choice == 1) {
			type = "가위";
		} else if(choice == 2) {
			type = "바위";
		} else if(choice == 3){
			type = "보";
		} 
		return type;
		
	} // end getHandType()
	
	
	
	
	
	
	
    public static void main(String[] args) {
        System.out.println("[ 가위 바위 보 게임  ]");
        Scanner sc = new Scanner(System.in);
        
        while(true){
            showMenu(); // 메뉴보여주기
 
            int userChoice = inputChoice(sc); // 사용자 입력
			if(0 > userChoice || userChoice > 3) {
				System.out.println("다시 입력해주세요!");
				continue;
			} else if(userChoice == 0){
               System.out.println("종료");
               break;  // 0 이면 종료
            } // end if
            // 컴퓨터 선택:   1 - 가위,  2- 바위,  3 - 보
            int computerChoice = (int) Math.floor(Math.random() * 3) + 1;
            displayChoice(userChoice, computerChoice); // 양측의 선택 보여주기
            computeResult(userChoice, computerChoice); // 승부결과 보여주기
        } // end while
        sc.close();
    } // end main()
    
	
    
    
    
    
	// method name: inputChoice
	// return: int (유저의 가위(0)/바위(1)/보(2) 선택 내용)... 모르겠음.. 가위는1바위는2보는3
	// arguments: Scanner sc (입력장치)
	public static int inputChoice(Scanner sc) {
		int choice;
		
		while(true) {
			choice = sc.nextInt();
	
			 return choice;
		} // end while
		
	} // end inputChoice()

	
	// method name: displayChoice
		// return: void
		// arguments:
		//   1) int user: 유저의 선택(가위(0)/바위(1)/보(2)) 가위1바위2보3
		//   2) int com: 컴퓨터의 선택(가위(0)/바위(1)/보(2)) 가위1바위2보3
		public static void displayChoice(int user, int com) {

			System.out.println("사용자 VS 컴퓨터");
			System.out.println(getHandType(user) + " VS " + (getHandType(com)));
		} // end displayChoice()
	
	
		// method name: computeResult
		// return: void
		// arguments:
		//   1) int user: 유저의 선택(가위(0)/바위(1)/보(2)) 가위1바위2보3
		//   2) int com: 컴퓨터의 선택(가위(0)/바위(1)/보(2)) 가위1바위2보3
	
		public static void computeResult(int user, int com) {
			
			if( user == com ) { //사용자와 컴퓨터의 결과값이 같은 경우 - 비기는 경우 
				System.out.println("비겼습니다.");
			} else if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)){
			// 사용자가 컴퓨터를 이기는 경우 - " You Win!! "	
				System.out.println("You Win!!");
			} else if ((com == 1 && user == 3) || (com == 2 && user == 1) || (com == 3 && user == 2)){
			// 컴퓨터가 이기는 경우 - " Com Win!! "
				System.out.println("Com Win!!");
			} 
		} // end computeResult()

} // end class

