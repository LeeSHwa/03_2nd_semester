import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NginxParser {
    public static void main(String[] args) {
        try {
            // 1. localhost:8888에 접속
            String url = "http://localhost:8888";
            Document doc = Jsoup.connect(url).get();

            // 2. HTML 문서에서 텍스트만 추출
            String bodyText = doc.body().text();

            System.out.println("--- Nginx 페이지 텍스트 내용 ---");
            System.out.println(bodyText);
            System.out.println("---------------------------------");

            // 3. "you"라는 단어(대소문자 구분 없이) 개수 세기
            String targetWord = "you";
            int count = 0;

            // 원본 텍스트를 소문자로 변경하여 "you" 찾기
            String lowerText = bodyText.toLowerCase();

            // 간단한 카운팅 로직
            int index = lowerText.indexOf(targetWord);
            while (index != -1) {
                count++;
                index = lowerText.indexOf(targetWord, index + 1);
            }

            System.out.println("페이지에서 '" + targetWord + "' 단어 개수: " + count);

        } catch (Exception e) {
            System.err.println("Nginx 서버에 연결할 수 없습니다. Nginx가 실행 중인지 확인하세요.");
            e.printStackTrace();
        }
    }
}