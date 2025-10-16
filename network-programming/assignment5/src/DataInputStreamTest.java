
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest{
    public static void main(String[] args) throws IOException{
        
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")))){

			
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());
            
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());


		}
    }
}