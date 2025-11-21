import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {
    public static void main(String[] args) {
        try {
            URL u = new URL("Https://www.hanbat.ac.kr");
            URLConnection uc = u.openConnection();

            for (int j = 0; ; j++) {
                String header = uc.getHeaderField(j); // response header에 있는 걸 반환?
                if (header == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        } catch (
                MalformedURLException ex) {
            System.err.println("That is not a URL I understand.");
        } catch (
                IOException ex) {
            System.err.println(ex);
        }
        System.out.println();
    }
}
