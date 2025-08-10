package Assignment_Java8;

import java.util.*;

public class MethodReferenceSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter names to sort (space-separated):");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        // Method reference instead of lambda
        names.sort(String::compareTo);

        System.out.println("Sorted Names: " + names);
        scanner.close();
    }
}
