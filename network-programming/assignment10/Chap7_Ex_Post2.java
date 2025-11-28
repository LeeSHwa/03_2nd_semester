package chap7;

 
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Chap7_Ex_Post2 {
	public static void main(String[] args) {
        // 1. HttpClient 생성
        HttpClient client = HttpClient.newHttpClient();

        // 2. form 데이터 구성 (URLEncoder 필수!)
        String formData = buildFormData("hwang", "Network");

        // 3. 요청 만들기
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .build();

        try {
            // 4. 요청 보내고 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Body:");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // form 데이터 만들어주는 헬퍼 메서드
    private static String buildFormData(String name, String project) {
        StringBuilder sb = new StringBuilder();
        sb.append("name=").append(URLEncoder.encode(name, StandardCharsets.UTF_8));
        sb.append("&");
        sb.append("project=").append(URLEncoder.encode(project, StandardCharsets.UTF_8));
        return sb.toString();
    }
}
