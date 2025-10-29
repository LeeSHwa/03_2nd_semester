import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GZipAllFiles {

    public final static int THREAD_COUNT = 8;

    public final static String TARGET_DIRECTORY = "C:/03_2nd_semester/network-programming/assignment7/test-files";

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        File dir = new File(TARGET_DIRECTORY);

        if (!dir.exists() || !dir.isDirectory()) {

            pool.shutdown();
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            pool.shutdown();
            return;
        }

        int taskCount = 0;
        for (File f : files) {
            if (!f.isDirectory() && !f.getName().endsWith(".gz")) {
                Runnable task = new GZipRunnable(f);
                pool.submit(task);
                taskCount++;
            }
        }

        
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("========================================");
        System.out.println("Thread Count: " + THREAD_COUNT);
        System.out.println("Total Elapsed Time (ms): " + (elapsedTime / 1_000_000.0));
        System.out.println("========================================");
    }
}