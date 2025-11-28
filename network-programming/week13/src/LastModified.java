import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class LastModified {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.oreilly.com");
//            URL u = new URL("https://www.hanbat.ac.kr");

            HttpURLConnection http = (HttpURLConnection) u.openConnection();

            http.setRequestMethod("HEAD");
            System.out.println(u + " was last modified at "
                    + new Date(http.getLastModified()));
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
