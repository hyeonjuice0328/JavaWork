package practice.cardcompany;

public class Company {

	// 필요한 변수, 메소드, 생성자 정의하기
	
	private static Company instance = new Company();
	
	private Company() {}
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		return instance;
	} // end if

	//카드발급
	public Card createCard() {
		Card card = new Card();
		return card;
	}
	
} // end class

//	static int count = 10000; ---> Card클래스
//	
//	private Company() {
//		count++;
//		System.out.println("카드 고유 번호 : " + count);
//	} // end company()
//	
//	private static Company instance = null;
//	static Company getInstance() {
//		if(instance == null) {
//			instance = new Company();
//		} //end if
//		return instance;
//	} // end getInstance()
//	
//	public  Card createCard() {
//		
//		return null;
//	}