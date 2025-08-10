package Assignment_Java8;

import java.util.*;
import java.util.stream.Collectors;

public class ANameFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter names separated by space:");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        // Filter names starting with "A"
        List<String> aNames = names.stream()
                                   .filter(name -> name.startsWith("A"))
                                   .collect(Collectors.toList());

        System.out.println("Names starting with 'A': " + aNames);
        scanner.close();
    }
}
