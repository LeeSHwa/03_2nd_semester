import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TraceTest {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://localhost:8888/assignment-check");

            HttpURLConnection http = (HttpURLConnection) u.openConnection();
            http.setRequestMethod("TRACE");

            // 임의의 헤더 추가
            http.setRequestProperty("X-My-Custom-Header", "Hello-Network");

            // header 출력
            for (int j = 0; ; j++){
                String header = http.getHeaderField(j);
                if (header == null) break;
                System.out.println(http.getHeaderFieldKey(j) + " : " + header);
            }

            //body 출력
            try (InputStream in = http.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (
                MalformedURLException ex) {
            System.err.println("That is not a URL I understand");
        } catch (
                IOException ex) {
            System.err.println(ex);
        }
        System.out.println();
    }
}
