import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ThreadTest extends Thread{

    private String filename;

    public ThreadTest(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try{
            FileInputStream in = new FileInputStream(filename);                 // filename을 입력값으로 받고
            MessageDigest sha = MessageDigest.getInstance("SHA-256"); // SHA-256을 적용하기위해 sha 변수에 할당
            DigestInputStream din = new DigestInputStream(in, sha);             

            while (din.read() != -1);
            din.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            result.append(bytesToHex(digest));
            System.out.println(result);

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex){
            System.err.println(ex);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash){
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static void main(String[] args){
        String[] files = {
            "network-programming/assignment6/src/file1.txt",
            "network-programming/assignment6/src/file2.txt",
            "network-programming/assignment6/src/file3.txt"
        };

        for (String filename : files) {
            Thread t = new ThreadTest(filename);
            t.start();
        }
    }
}
