package phonebook02.mvc;

import java.util.Arrays;

// CONTROLLER 객체 
// 어플리케이션의 동작, 데이터 처리(CRUD).. (Business logid 담당) 
public class PhonebookManager implements PhonebookController {

	public static final int MAX_DATA = 3;//최대 데이버 개수 
	
	//배열로 구현
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];
	
	//몇개의 데이터가 저장되었는지 
	private int count = 0;
	
	
	// singleton design 적용
	private PhonebookManager() {	}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	
	
	//전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		int result = PhonebookController.QUERY_FAIL;
		//매개변수 검증 : 이름 필수 
		if(name == null || name.trim().length() == 0) {
			return result; // 이름값이 null 이거나 empty 일 때 실패
		}
		
		
		// 만약 배열이 다 차있으면 MAX_DATA만큼 새 배열 추가
		if(count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length+MAX_DATA); 
			// (배열(3개짜리)가 다 찼으니 기존에 있던 배열 + MAX_DATA(3) 으로 복사 )<<이걸 pbList에 저장
		}
		
		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid() + 1); // 기존 최대 uid 값 보다 1 증가한 값.
		//uid 와 배열index는 다름
		count++;
		
		return 1;
	}

	//모든 정보들을 다 배열로 리턴!
	@Override
	public PhonebookModel[] selectAll() {
		return Arrays.copyOfRange(pbList, 0, count); //0부터 count직전까지
	}
	//특정 uid의 데이터 검색 리턴
	//못찾으면 null 리턴 
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for(int index = 0; index < count; index++ ) { // 배열로 되어있으니 인덱스 모두 뒤져보기  
			if(pbList[index].getUid() == uid)
				return pbList[index]; // uid값 발견하면 return 
		}

		return null; // 못찾으면 null 리턴 
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		int result = PhonebookController.QUERY_FAIL;
		
		//매개변수 검증
		if(uid < 1 ) return result;
		if(name == null || name.trim().length() == 0) return result; //이름 입력 필수
		
		//특정 uid 값을 가진 데이터릐 배열 인덱스 찾기 
		int index = findIndexByUid(uid);
		if(index < 0) return result;
		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		result = 1;
		
		
		return result;
	}

	@Override
	public int deleteByUid(int uid) {
		int result = PhonebookController.QUERY_FAIL;
		
		//매개변수 검증
		if( uid < 1 )return result;
		//index 찾기
		int index = findIndexByUid(uid);
		if(index < 0)
			return result;
		
		//배열 뒤의 원소들을 앞으로 이동 
		for(int i = index, j = index + 1; j < count; i++, j++) {
			pbList[i] = pbList[j];
		}
		
		// count 감소 
		count--;
		result = 1; // 삭제 성공
		
		return result;
	}

	//데이터 중에서 가장 큰 uid 값을 찾아내 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		for(int index = 0; index < count; index++) {
			if(maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		return maxUid;
	}
	
	//특정 uid 값을 가진 데이터릐 배열 인덱스 찾기
	private int findIndexByUid(int uid) {
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return index;
			}
		}
		return -1; // 못찾았으면 -1리턴
	}
	
	
	
	
	
}
