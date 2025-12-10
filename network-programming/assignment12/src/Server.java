import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept(); // 클라이언트가 접속하면

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            clientWriters.add(writer);

            pool.submit(new ClientHandler(socket, writer));
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final PrintWriter myWriter;

        public ClientHandler(Socket socket, PrintWriter writer) {
            this.socket = socket;
            this.myWriter = writer;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println("수신된 메시지 :" + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("클라이언트 나감");
            } finally {
                clientWriters.remove(myWriter);
                try {
                    socket.close();
                } catch (IOException e) {
                }

            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    if (writer != myWriter) { // 발송한 사람한테는 broadcast 안함
                        writer.println(message);
                    }
                }
            }
        }
    }
}
