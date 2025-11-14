import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

public class LookupTask implements Callable<String> {
    public static final String BLACKHOLE = "zen.spamhaus.org";

    private String line;

    public LookupTask(String line){
        this.line = line;
    }

    @Override
    public String call() {
        try{
        int index = line.indexOf(' ');
        String address = line.substring(0, index);
        String theRest = line.substring(index);
        String hostname = InetAddress.getByName(address).getHostName();

        if (isSpammer(address) == true){
            return hostname + " " + "Spam" + " " +theRest;
            }
        
        return hostname + " " + theRest;
        } catch (Exception ex) {
            return line;
        }
    }


    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();

            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }

            InetAddress.getByName(query);

            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}