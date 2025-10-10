import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InputStreamTest{
    public static void main(String[] args) {

        try (InputStream in = new FileInputStream("data1010.txt")) {

            int bytesRead = 0;
            int bytesToRead = 1024;
            byte[] input = new byte[bytesToRead];
            while (bytesRead < bytesToRead) {
                int result = in.read(input, bytesRead, bytesToRead - bytesRead);
                System.out.println("result:"+result +'\n');  //for test
                if (result == -1)
                    break; // end of stream
                bytesRead += result;
            }

            //System.out.println("Read Input:" + Arrays.toString(input));

            for (int i = 0; i < 1024; i++)

                System.out.print((char)input[i]);

            //System.out.println("\n" + DatatypeConverter.printHexBinary(input));

//			System.out.print("\ncarriage return");

//			System.out.print("\r");

//			System.out.print("line feed");

//			System.out.print("\n");

//			System.out.print("crlf");

//			System.out.print("\r\n");

//			System.out.print("end");

        

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();

        } 

	}}