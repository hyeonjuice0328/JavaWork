package com.lec.java.crawl10;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* XML, Json 파싱1
 * 
 * 내 키값: 7848716d426a6a7539307444475842
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/7848716d426a6a7539307444475842/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class Crawl10Main {

	public static final String REQ_SERVICE = "CardSubwayStationNew"; // 서비스 이름
	public static final String API_KEY = "7848716d426a6a7539307444475842"; // 내 키값

	public static void main(String[] args) {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");

		// 변수 선언
		int startIndex; // 요청시작위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex; // 요청종료위치 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
		String date; // 날짜 yyyymmdd 형식

		String url_address;
		StringBuffer sb; // response (url adress 받은 걸 저장)

		// 한번 뽑아 보기??
		startIndex = 1; // 인덱스 1번부터
		endIndex = 5; // 인덱스 5번까지
		date = "20200329"; // 날짜 지정

		// XML 파싱!ㅕ
		System.out.println("--- MXL PARSING ---");
		url_address = buildUrlAddress("xml", startIndex, endIndex, date);
		// System.out.println(url_address); > 확인완료
		sb = readFromUrl(url_address);
		// System.out.println(sb); > 확인완료
		parseXML(sb.toString()); // XML 파싱해서 문자열로 출력

		
		  System.out.println("--- JSON PARSING ---"); 
		  url_address = buildUrlAddress("json", startIndex, endIndex, date);
		  //System.out.println(url_address); > 확인완료 
		  // System.out.println(sb); > 확인완료
		  sb = readFromUrl(url_address);
		  parseJSON(sb.toString());

		System.out.println("\n프로그램 종료");
	} // end main()

	// URL만들 메소드
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		return url_address;
	} // end buildUrlAddress()

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체

		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결' 이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함

				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {

					in = conn.getInputStream(); // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader

					int cnt; // 읽은 글자 개수
					while ((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					}

				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 Connection 해제
		}

		return sb;

	}

	// XML 파싱
	// static은 static끼리만 사용 가능
	// static method : 인스턴스를 생성하지 않아도 사용할 수 있는 메소드
	// String type의 xmlText 를 리턴하는 parseXML static 메소드
	public static void parseXML(String xmlText) {
		// import javax.xml.parsers.DocumentBuilder;
		DocumentBuilderFactory dbFactory;
		// DocumentBuilder는 DocumentBuilderFactory를 통해서만 사용할 수 있다.
		DocumentBuilder dBuilder;

		try {
			// DOM parser 객체(DocumentBuilderFactory,DocumentBuilder)는생성/생성자가 따로 없음
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

			// 문자열(String)로 받은것 InputStream으로 변환
			// ByteArrayInputStream String type으로 받아서.getBytes를 쓰면 byte[]로
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));

			// InputStream > DOM 객체 생성
			// Document:w3c.dom 을 import
			Document dom = dBuilder.parse(in);

			// DOM 최상위 document element 추출
			Element docElement = dom.getDocumentElement(); // DOM의 최상위 element
			// XML 파싱 하기 전에 꼭 normalize() 해주기!
			docElement.normalize(); // 흩어진 text node 들을 정렬하는 등의 절차, (내부적동작)

			// DOM 내의 데이터 parsing
			NodeList nList = docElement.getElementsByTagName("row");
			// .getElementsByTagName특정 elements들을 가진 NodeList를 리턴
			System.out.println("row 갯수" + nList.getLength() + " 개");
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				// node.getNodeType() > 정수값 출력된다.
				// System.out.println("node type : " + node.getNodeType());
				// node가 element node인 경우에만 파싱 (element node 는 1을 리턴)
				if (node.getNodeType() != node.ELEMENT_NODE)
					continue;
				// element는 node를 상속받는 관계
				Element rowElement = (Element) node;
				// getElementsByTagName복수 리턴 / item(0):첫번째 item / .getChildNodes().item(0):text
				// node/ .getNodeValue():문자열
				String LINE_NUM = rowElement.getElementsByTagName("LINE_NUM").item(0).getChildNodes().item(0)
						.getNodeValue().trim();
				String SUB_STA_NM = rowElement.getElementsByTagName("SUB_STA_NM").item(0).getChildNodes().item(0)
						.getNodeValue().trim();
				String RIDE_PASGR_NUM = rowElement.getElementsByTagName("RIDE_PASGR_NUM").item(0).getChildNodes()
						.item(0).getNodeValue().trim();
				String ALIGHT_PASGR_NUM = rowElement.getElementsByTagName("ALIGHT_PASGR_NUM").item(0).getChildNodes()
						.item(0).getNodeValue().trim();

				System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM,
						ALIGHT_PASGR_NUM);
			}

			// 예외처리 : ParserConfigurationException
		} catch (ParserConfigurationException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드
		// 파일에 복사해서 넣고 Build Path
		
		JSONObject jobj = new JSONObject(jsonText); //Json파싱 : JSONObjexct <- String
		// String 타입으로 받아서  제이슨오프젝트 타입으로 파싱한다.(받은Json파일이 오브젝트타입이라서) 
		JSONArray row = jobj.getJSONObject("CardSubwayStatsNew").getJSONArray("row");
		//jobj.getJSONObject("CardSubwayStatsNew") -> 오브젝트 
		// row [] 를 가지고 와야 해서 : getJSONArray("row")
		System.out.println("row 의 갯수 : " + row.length());
		System.out.println();
		for (int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i); // 지하철역정보 
			String LINE_NUM = station.getString("LINE_NUM");
			String SUB_STA_NM = station.getString("SUB_STA_NM");
			int RIDE_PASGR_NUM = station.getInt("RIDE_PASGR_NUM");
			int ALIGHT_PASGR_NUM = station.getInt("ALIGHT_PASGR_NUM");
			
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
					LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
		}
     
		
		
		
	} // end parseJSON()

} // end class
