package practice.cardcompany;

public class Card {
	
	private int cardNumber;
	private static int serialNum = 10000; // 카드번호가 10001부터 
	
	public Card() {
		
		serialNum++; // serialNum 증가
		cardNumber = serialNum; // serialNum을 cardNumber에 담는다.
		System.out.println("카드 고유 번호 : " + serialNum); 
	
	} // end Card()
	
	//getter setter
	public int getCardNumber() {
		
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
//	int myCard;
//	int yourCard;
//	// 필요한 변수, 메소드, 생성자 정의하기
//	public Card() {
//	}
//	public int getMyCard() {
//		return myCard;
//	}
//	public void setMyCard(int myCard) {
//		this.myCard = myCard;
//	}
//	public int getYourCard() {
//		return yourCard;
//	}
//	public void setYourCard(int yourCard) {
//		this.yourCard = yourCard;
//	}
//	
//	public char[] getCardNumber() {
//		
//		return null;
	
	
	
} // end class
