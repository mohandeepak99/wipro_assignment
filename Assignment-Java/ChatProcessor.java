import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {
    private static final String POISON = "__END__";

    public static void main(String[] args) throws Exception {
        // Shared, thread-safe buffer that can hold at most 5 messages
        LinkedBlockingQueue<String> buffer = new LinkedBlockingQueue<>(5);

        // Reader (consumer) thread: reads messages one by one
        Thread reader = new Thread(() -> {
            try {
                while (true) {
                    String msg = buffer.take();        // waits if empty
                    if (POISON.equals(msg)) {
                        System.out.println("Reader: shutdown signal received.");
                        break;
                    }
                    System.out.println("Reader got -> " + msg);
                    // Simulate processing time
                    Thread.sleep(800);
                }
            } catch (InterruptedException ignored) {}
        });

        reader.start();

        // Writer (producer) loop: read user input and add to buffer
        Scanner sc = new Scanner(System.in);
        System.out.println("Type chat messages. 'exit' to stop.");
        try {
            while (true) {
                String line = sc.nextLine();
                if ("exit".equalsIgnoreCase(line)) break;

                // put() waits if the buffer already has 5 items (auto-pause)
                buffer.put(line);
                System.out.println("Added -> " + line + " | buffer size: " + buffer.size());
            }
        } finally {
            // Send shutdown “poison pill” to reader and wait for it to finish
            buffer.put(POISON);
            reader.join();
            sc.close();
            System.out.println("ChatProcessor stopped.");
        }
    }
}
