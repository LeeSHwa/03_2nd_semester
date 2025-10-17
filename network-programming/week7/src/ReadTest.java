
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

    public class ReadTest{

        public static void main(String[] args) {
    //FileReader in = new FileReader("dataWriter.txt"  , Charset.forName("utf-8"))  // java 11 
            try (FileReader in = new FileReader("dataWriter1010.txt", StandardCharsets.UTF_8 );  
                    FileWriter out = new FileWriter("dataout1010.txt" )
            ) {
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                System.out.println(in.getEncoding()); // current encoding
                System.out.println(out.getEncoding()); // current encoding
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        
    }
    }