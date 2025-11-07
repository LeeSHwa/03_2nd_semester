import java.net.InetAddress;
import java.net.UnknownHostException;


public class SpamCheck {
	public static final String BLACKHOLE = "zen.spamhaus.org";  //"sbl.spamhaus.org";  //www.spamhaus.org

	public static void main(String[] args) throws UnknownHostException {
		
		args=new String[] {"www.hanbat.ac.kr", "5.199.130.188", "86.57.13.235"}; // 5.199.130.188 not spam. // 
		
		for (String arg : args) {
			if (isSpammer(arg)) {
				System.out.println(arg + " is a known spammer.");
			} else {
				System.out.println(arg + " appears legitimate.");
			}
		}
	}

	private static boolean isSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			System.out.println(address);
			byte[] quad = address.getAddress();
			for (byte b : quad)
				System.out.println(b); // byte check 
			
			String query = BLACKHOLE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;				
				query = unsignedByte + "." + query;
			}
			System.out.println("query="+query);
		
			InetAddress ad=  InetAddress.getByName(query); 
			System.out.println(ad);
			
			return true;
		} catch (UnknownHostException e) {
			System.out.println("unknownhost--NO SPAM");
			return false;
		}
	}
}