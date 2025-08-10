import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    String name;
    int urgency;

    Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}

public class SmartJobPicker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lower urgency value = higher priority
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                if (j1.urgency != j2.urgency) {
                    return Integer.compare(j1.urgency, j2.urgency); // lower = higher
                } else {
                    return Integer.compare(j1.name.length(), j2.name.length()); // shorter name wins
                }
            }
        });

        System.out.println("Enter job name and urgency (e.g., Email 2). Type 'exit' to stop:");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ");
            String jobName = parts[0];
            int urgency = Integer.parseInt(parts[1]);

            jobQueue.add(new Job(jobName, urgency));
            System.out.println("Most urgent job right now: " + jobQueue.peek());
        }

        System.out.println("\nJobs to be processed in order:");
        while (!jobQueue.isEmpty()) {
            System.out.println(jobQueue.poll());
        }
    }
}
