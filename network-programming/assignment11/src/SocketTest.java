import java.io.*;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        String host = "whois.kr";
        int port = 43;
        String domainQuery = "hanbat.ac.kr";

        try {
            QueryDomain(host, port, domainQuery);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void QueryDomain(String host, int port, String queryDomain) throws Exception {
        Socket socket = new Socket(host, port);

        Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        out.write(queryDomain);
        out.write("\r\n");
        out.flush();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        String line = "";
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}

