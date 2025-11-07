import java.net.InetAddress;
import java.net.UnknownHostException;

public class OreillyByName {
    public static void main (String[] args){ 
        try { 
            // InetAddress address = InetAddress.getByName("www.oreilly.com");
            InetAddress address = InetAddress.getByName("www.naver.com");
            // InetAddress address = InetAddress.getByName("www.google.com");

            System.out.println(address); 

            // CanonicalHostName? -> 정식 호스트 네임, 한국에서는 간사이공항 나옴
            System.out.println("Canonical Host name: " + address.getCanonicalHostName());

            // 아래는 ip주소로 get host name
            InetAddress address2 = InetAddress.getByName("223.194.192.38");
            System.out.println(address2.getHostName());

            InetAddress[] addresses = InetAddress.getAllByName("www.naver.com");
            // String addresses = InetAddress.getByName("1.3.3.4").getHostName();

            for (InetAddress address3 : addresses) {
                System.out.println(address3);
            }

            } catch (UnknownHostException ex) {
                System.out.println("Could not find"); 
            }
    }       

}
