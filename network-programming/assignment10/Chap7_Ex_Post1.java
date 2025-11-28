    package chap7;

 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Chap7_Ex_Post1 {
	 public static void main(String[] args) {
	        try {
	            URL url = new URL("https://postman-echo.com/post");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	            conn.setRequestMethod("POST"); // 글 써줘
	            conn.setDoOutput(true);

	            String data = "name=hwang&project=Network";
	            byte[] out = data.getBytes("UTF-8");

	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Content-Length", String.valueOf(out.length));

	            try (OutputStream os = conn.getOutputStream()) {
	                os.write(out);
	            }

	            try (BufferedReader br = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream(), "UTF-8")
	            )) {
	                String line;
	                while ((line = br.readLine()) != null) {
	                    System.out.println(line);
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
