package chap7;

 
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Chap7_Ex_Post4 {
	public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        String json = """
                {
                  "message": "hello",
                  "from": "hwang"
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post"))
                // 일반 헤더
                .header("Content-Type", "application/json")
                .header("X-Student-Name", "Hwang")
                .header("X-Project", "NetworkProgrammingTest")
                // 쿠키 헤더
                .header("Cookie", "sessionId=abc123; user=hwang")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Body:");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
