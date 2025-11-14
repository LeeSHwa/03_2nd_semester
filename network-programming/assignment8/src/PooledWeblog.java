import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class PooledWeblog {
    private final static int NUM_THREADS = 4;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Queue<LogEntry> results = new LinkedList<LogEntry>();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("assignment8/src/accesslog_sw_24.txt"), "UTF-8"));) {
            for (String entry = in.readLine(); entry != null; entry = in.readLine()) { 
                LookupTask task = new LookupTask(entry);
                Future<String> future = executor.submit(task);
                LogEntry result = new LogEntry(entry, future);
                results.add(result);
            }
        }

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("assignment8/access_hosts.txt")))){
            // Start printing the results. This blocks each time a result isn't ready.
            for (LogEntry result : results) {
                try {
                    writer.println(result.future.get());
                } catch (InterruptedException | ExecutionException ex) {
                    writer.println(result.original);
                }
            }
        }

        
        executor.shutdown();
    }

    private static class LogEntry {
        String original;
        Future<String> future;

        LogEntry(String original, Future<String> future) {
            this.original = original;
            this.future = future;
        }
    }
}