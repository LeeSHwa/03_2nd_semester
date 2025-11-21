import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EncodingAwareSourceViewer {
    public static void main(String[] args) {
        try {
            // set default encoding
            String encoding = "ISO-8859-1";
            URL u = new URL("https://hanbat.ac.kr");

            URLConnection uc = u.openConnection();
            String contentType = uc.getContentType();
            System.out.println(contentType);

            int encodingStart = contentType.indexOf("charset=");              // "charset=" string을 찾아서 인덱스 반환
            if (encodingStart != -1) {
                encoding = contentType.substring(encodingStart + 8); // 반환 받은 인덱스는 C의 인덱스임, 길이만큼 더해줌
            }                                                                 // 그래서 결국 encoding type을 반환받음(ETF-8 등)
            InputStream in = new BufferedInputStream(uc.getInputStream());
            Reader r = new InputStreamReader(in, encoding);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            r.close();
        } catch (MalformedURLException ex) {
            System.err.println(" is not a parseable URL");
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Serversent an encoding Java does not support: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
