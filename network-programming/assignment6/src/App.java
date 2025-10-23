import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class App {
    
    public static void main(String[] args) throws Exception {

		try (OutputStream outFile = new FileOutputStream("network-programming\\assignment6\\src\\data.txt");

        OutputStreamWriter outWriter = new OutputStreamWriter(outFile, "ascii") ) 
        {
            outWriter.write("한밭대학교test1234");
		} 

        catch (IOException ex)
        {
			System.err.println(ex.getMessage());
		}
    }
}
