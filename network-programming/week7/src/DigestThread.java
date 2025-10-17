import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestThread implements Runnable {
    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);

            while (din.read() != -1)
                ;

            din.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            // result.append(DatatypeConverter.printHexBinary(digest));
            result.append(byteToHex(digest));
            System.out.println(result);

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        String[] temp = { "data.txt", "data.bin" };
        for (String filename : temp) {
            DigestThread dr = new DigestThread(filename);
            Thread t = new Thread(dr);
            t.start();
        }
    }

    public static String byteToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String st = String.format("%02X", b);
            sb.append(st);
        }
        return sb.toString();
    }
}