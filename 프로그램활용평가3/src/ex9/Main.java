package ex9;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
문제9]
Jsoup 라이브러리를 활용하여, 아래의 내용을 파싱하여 결과보여주기를 작성해보세요 (20점)

네이버 메인 페이지 뉴스캐스트
URL : https://www.naver.com

[결과예]
여야, 앞다퉈 '전국민 재난지원금'…포퓰리즘 논란 속 공약경쟁
정부, 자가격리자에 '전자팔찌' 착용 가닥…'무단이탈' 강력차단
WHO, 문 대통령에 "세계보건총회서 아시아 대표로 발언해달라"
아베 "내일이라도 긴급사태 선언"…도쿄·오사카 등 7곳 대상
터져 나오는 막말·실언…여야 '대형악재' 경계령
'n번방' 통로 역할 '와치맨' "피해자에 진심으로 사죄"
수도권 중심 코로나19 해외유입·집단발병 지속
자가격리 어기고 사찰 방문한 엄마와 아들 고발키로
숭실대 교수 "기업에서 아예 안 뽑습니다" 학교 비하 논란
이재명 "배달의민족 사과 진정성 의문…요금체제 원상복구해야"

 */
public class Main {

	public static void main(String[] args) throws IOException {
		String url;
		Response response;
		Document doc; // DOM

		url = "https://www.naver.com/";

		response = Jsoup.connect(url).execute();
		doc = response.parse();
		Elements news_elements = doc.select("#news_cast li.ca_item");
		for (Element news_element : news_elements) {
			Element element = news_element.selectFirst("a.ca_a");
			System.out.println(element.text()); // content 의 text 추출
		}
	}

}
