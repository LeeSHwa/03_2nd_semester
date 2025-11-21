import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NginxParser {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8888";
            Document doc = Jsoup.connect(url).get();

            String bodyText = doc.body().text();

            System.out.println("--- Nginx 페이지 텍스트 내용 ---");
            System.out.println(bodyText);
            System.out.println("---------------------------------");

            String targetWord = "you";
            int count = 0;

            String lowerText = bodyText.toLowerCase();

            int index = lowerText.indexOf(targetWord);
            while (index != -1) {
                count++;
                index = lowerText.indexOf(targetWord, index + 1);
            }

            System.out.println(targetWord + " 개수: " + count);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}