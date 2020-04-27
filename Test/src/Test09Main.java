import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test09Main {

	public static void main(String[] args) throws IOException {
		String url;
		Document doc;
		Response response;
		Elements elements;

		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select("#old_contetn > table > tbody");

		for (Element e : elements) {

			String Title = e.selectFirst("div.tit3 a.title").text().trim();
			String Rank = e.selectFirst("td.ac img.alt").text().trim();

			System.out.println(Rank + ":" + Title);

			System.out.println("\n프로그램 종료");
		}

	}

}
