package Assignment_Java8;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter names separated by space:");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        // Count names longer than 5 characters
        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();

        System.out.println("Names longer than 5 characters: " + count);
        scanner.close();
    }
}
