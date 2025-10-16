
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest{

    static final String dataFile = "data.bin";
    
    public static void main(String[] args) throws IOException {		  

		try ( DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){


            out.writeInt(1);
            out.writeDouble(1.0);
            out.writeUTF("abc한밭");
            
            out.writeInt(2);
            out.writeDouble(2.0);
            out.writeUTF("abc대학교");
        }  
    }

}