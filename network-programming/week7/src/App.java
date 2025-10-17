import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class App {
public static void main(String[] args) {

		

		try (OutputStream outFile = new FileOutputStream("dataWriter1010.txt");

        OutputStreamWriter outWriter = new OutputStreamWriter(outFile, "utf-8") ) 
        {
            outWriter.write("한밭test123");
		} 

        catch (IOException ex) 
        {
			System.err.println(ex.getMessage());
		}



		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out,"utf-8"))) 
        {
			out.write("한밭test123", 3, 5);
		}
        
        catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

	}
}
