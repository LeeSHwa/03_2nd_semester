import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ThreadTest2 extends Thread {

    private String filename;

    public ThreadTest(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        calculateHash(this.filename);
    }

    public static void calculateHash(String filename) {
        try (
            FileInputStream in = new FileInputStream(filename);
            DigestInputStream din = new DigestInputStream(in, MessageDigest.getInstance("SHA-256"))
        ) {
            byte[] buffer = new byte[8192];
            while (din.read(buffer) != -1); // 버퍼를 채우며 파일 끝까지 읽기

            // 3. 해시 계산 완료 (결과를 사용하지는 않음)
            byte[] digest = din.getMessageDigest().digest();


        } catch (IOException | NoSuchAlgorithmException ex) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        String[] baseFiles = {
            "network-programming/assignment6/src/file1.txt",
            "network-programming/assignment6/src/file2.txt",
            "network-programming/assignment6/src/file3.txt"
        };

        int[] testCases = {10, 20, 30, 40, 50};

        for (int N : testCases) {
            System.out.println("--- " + N + "개 파일 테스트 시작 ---");

            List<String> fileList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                fileList.add(baseFiles[i % baseFiles.length]);
            }

            long startTimeSeq = System.nanoTime();
            for (String file : fileList) {
                calculateHash(file); // 1번 끝나야 2번 실행
            }
            long endTimeSeq = System.nanoTime();
            long sequentialTime = (endTimeSeq - startTimeSeq) / 1_000_000; // 밀리초(ms)
            System.out.println("[스레드 X] 순차 처리: " + sequentialTime + " ms");

            List<Thread> threads = new ArrayList<>();
            long startTimeThread = System.nanoTime();

            for (String file : fileList) {
                Thread t = new ThreadTest(file);
                t.start();      // 스레드 시작
                threads.add(t); // 나중에 join()을 위해 리스트에 저장
            }

            for (Thread t : threads) {
                t.join();       // 해당 스레드가 끝날 때까지 main 스레드가 여기서 멈춤
            }
            
            long endTimeThread = System.nanoTime();
            long threadedTime = (endTimeThread - startTimeThread) / 1_000_000; // 밀리초(ms)
            System.out.println("[스레드 O] 병렬 처리: " + threadedTime + " ms");
            System.out.println("---------------------------\n");
        }
    }
}