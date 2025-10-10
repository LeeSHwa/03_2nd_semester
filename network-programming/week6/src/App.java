import java.io.IOException;
import java.io.OutputStream;

public class App {

    public static void main(String[] args) throws Exception {
        // try (OutputStream out = new FileOutputStream("data1010.txt"))
        // {
        //     long startTime = System.nanoTime();

        //     generateCharacters(out);
        //     long estimatedTime1 = System.nanoTime() - startTime;

        // } catch (IOException ex) {
        //     System.err.println(ex.getMessage());
        // }   


        try {
            long startTime = System.nanoTime();

            generateCharactersBuf(System.out);
            long estimatedTime2 = System.nanoTime() - startTime;
            System.out.println("총 걸린 시간: " + estimatedTime2 + "나노초(ns)" );

            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;

        // while (true) { /* infinite loop */
        for (int numline = 0; numline < 100; numline++){
            // 한 줄에 정해진 개수만큼 문자를 출력합니다.
            out.write(numline);
            out.write(" : ".getBytes());
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write(
                    ((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter
                );
                } // 계산해서 값 하나를 쓰는거

            // 줄바꿈 문자를 출력합니다.
            out.write('\r'); // Carriage Return
            out.write('\n'); // Line Feed

            // 다음 줄의 시작 문자를 계산합니다.
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
        }
        }


    public static void generateCharactersBuf(OutputStream out) throws IOException {

        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;

        byte[] line = new byte[numberOfCharactersPerLine + 2]; // the +2 is for the carriage return and linefeed

        // while (true) { // infinite loop
        for (int numline = 0; numline < 100; numline++){

            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r'; // carriage return
            line[73] = (byte) '\n'; // line feed
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }
    }
