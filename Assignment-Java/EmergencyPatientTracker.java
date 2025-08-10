import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    final String name;
    final int severity;       // lower = more urgent
    final long arrivalOrder;  // increasing number to break ties

    Patient(String name, int severity, long arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return name + " (severity " + severity + ", order " + arrivalOrder + ")";
    }
}

public class EmergencyPatientTracker {
    public static void main(String[] args) {
        final int CAPACITY = 5;
        long counter = 0; // increments for each arrival

        // Order by severity asc; if equal, arrivalOrder asc (older first)
        PriorityQueue<Patient> pq = new PriorityQueue<>(
            new Comparator<Patient>() {
                @Override
                public int compare(Patient a, Patient b) {
                    int bySeverity = Integer.compare(a.severity, b.severity);
                    return (bySeverity != 0) ? bySeverity
                                             : Long.compare(a.arrivalOrder, b.arrivalOrder);
                }
            }
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Commands: add <name> <severity> | treat | exit");

        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;

            if (line.toLowerCase().startsWith("add ")) {
                String[] parts = line.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Use: add <name> <severity>");
                    continue;
                }
                String name = parts[1];
                int severity;
                try {
                    severity = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Severity must be an integer.");
                    continue;
                }

                if (pq.size() == CAPACITY) {
                    System.out.println("Queue full! Cannot add " + name + ".");
                } else {
                    pq.add(new Patient(name, severity, ++counter));
                    System.out.println("Added: " + name + " (severity " + severity + ")");
                }
            } else if (line.equalsIgnoreCase("treat")) {
                Patient next = pq.poll();
                if (next == null) {
                    System.out.println("No patients to treat.");
                } else {
                    System.out.println("Treating -> " + next.name +
                                       " (severity " + next.severity + ")");
                }
            } else {
                System.out.println("Unknown command.");
            }

            System.out.println("Current queue size: " + pq.size());
        }

        sc.close();
        System.out.println("Tracker stopped.");
    }
}
