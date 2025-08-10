package Assignment_Java8;

import java.util.*;
import java.util.stream.Collectors;

public class PrettyJoiner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city names separated by space:");
        List<String> cities = Arrays.asList(scanner.nextLine().split(" "));

        // Join using commas
        String joined = cities.stream()
                              .collect(Collectors.joining(", "));

        System.out.println("Joined Cities: " + joined);
        scanner.close();
    }
}
