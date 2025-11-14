import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupPractice {
    public static void main(String[] args) {

        String url = "https://www.hanbat.ac.kr";

        try {

            // 웹 페이지를 가져와서 파싱
            Document doc = Jsoup.connect(url).get();

            // <title> 출력
            System.out.println("Page Title: " + doc.title());

            // 모든 <a> 태그의 텍스트와 href 속성 출력
            Elements links = (Elements) doc.select("a[href]");

            for (Element link : links) {
                System.out.println("Text: " + link.text());
                System.out.println("Href: " + link.attr("href"));
                System.out.println("------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
