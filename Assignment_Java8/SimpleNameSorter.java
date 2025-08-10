package Assignment_Java8;
import java.util.*;

public class SimpleNameSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.println("Enter 5 names:");
        for (int i = 0; i < 5; i++) {
            names.add(scanner.nextLine());
        }

        // Sorting using Lambda expression
        names.sort((a, b) -> a.compareTo(b));

        System.out.println("Sorted Names: " + names);
        scanner.close();
    }
}
