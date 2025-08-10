import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> printQueue = new ArrayBlockingQueue<>(3);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter print jobs (type 'print' to process, 'exit' to stop):");

        while (true) {
            String job = sc.nextLine();

            if (job.equalsIgnoreCase("exit")) {
                break;
            }

            if (job.equalsIgnoreCase("print")) {
                String printedJob = printQueue.poll();
                if (printedJob != null) {
                    System.out.println("Printing: " + printedJob);
                } else {
                    System.out.println("No jobs to print.");
                }
            } else {
                boolean added = printQueue.offer(job); // doesn't throw error if full
                if (added) {
                    System.out.println("Added to queue: " + job);
                } else {
                    System.out.println("Queue full! Skipping job: " + job);
                }
            }

            System.out.println("Current queue: " + printQueue);
        }

        sc.close();
    }
}
