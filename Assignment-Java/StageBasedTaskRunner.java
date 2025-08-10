import java.util.concurrent.LinkedBlockingQueue;

class Task {
    int id;
    String description;

    Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task " + id + ": " + description;
    }
}

public class StageBasedTaskRunner {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Task> stage1 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Task> stage2 = new LinkedBlockingQueue<>();

        // Producer: add tasks to stage 1
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                Task t = new Task(i, "Do something " + i);
                try {
                    stage1.put(t);
                    System.out.println("[Producer] Added to Stage 1 -> " + t);
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {}
            }
        });

        // Stage 1 Processor: moves even-ID tasks to stage 2
        Thread stage1Processor = new Thread(() -> {
            try {
                while (true) {
                    Task t = stage1.take();
                    if (t.id % 2 == 0) {
                        stage2.put(t);
                        System.out.println("[Stage 1] Moved to Stage 2 -> " + t);
                    } else {
                        System.out.println("[Stage 1] Completed directly -> " + t);
                    }
                }
            } catch (InterruptedException ignored) {}
        });

        // Stage 2 Processor: final processing
        Thread stage2Processor = new Thread(() -> {
            try {
                while (true) {
                    Task t = stage2.take();
                    System.out.println("[Stage 2] Final processed -> " + t);
                }
            } catch (InterruptedException ignored) {}
        });

        producer.start();
        stage1Processor.start();
        stage2Processor.start();

        producer.join();
        // Sleep so processors finish
        Thread.sleep(3000);
        System.exit(0);
    }
}
