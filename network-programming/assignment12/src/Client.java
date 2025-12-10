import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to the server");

            // 서버가 보내는 메시지 받기
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        System.out.println("수신된 메시지 :" + line);
                    }
                } catch (IOException e) {
                    System.out.println("연결 끊어짐");
                }
            }).start();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) break;
                writer.println(input);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
