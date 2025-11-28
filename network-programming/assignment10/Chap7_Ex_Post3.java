package chap7;

 
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Chap7_Ex_Post3 {
	 public static void main(String[] args) {
	        HttpClient client = HttpClient.newHttpClient();

	        // 1. JSON 문자열 직접 생성 (라이브러리 없이)
	        String json = """
	                {
	                  "name": "hwang",
	                  "project": "Network",
	                  "type": "json-test"
	                }
	                """;

	        // 2. 요청 생성
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://postman-echo.com/post"))
	                .header("Content-Type", "application/json")
	                .POST(HttpRequest.BodyPublishers.ofString(json))
	                .build();

	        try {
	            // 3. 요청 전송 및 응답 수신
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	            System.out.println("Status code: " + response.statusCode());
	            System.out.println("Body:");
	            System.out.println(response.body());

	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
