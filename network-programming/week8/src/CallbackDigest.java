import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallbackDigest implements Runnable {
    
    private String filename;

    public CallbackDigest(String filename) {
        this.filename = filename;
    }

    @Override
    public void run(){
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);

            while (din.read() != -1);
            din.close();
            byte[] digest = sha.digest();

            CallbackDigestUserInterface.receiveDigest(digest, filename); // 좋은게 아님 because 아무 static이나 호출할 수 있으니까? 

        } catch (IOException | NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }

}
