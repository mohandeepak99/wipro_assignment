package Assignment_Java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilterChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter names separated by space:");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        // Define two predicates
        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWitha = name -> name.endsWith("a");

        // Chain predicates
        List<String> filtered = names.stream()
                                     .filter(startsWithA.and(endsWitha))
                                     .collect(Collectors.toList());

        System.out.println("Names starting with 'A' and ending with 'a': " + filtered);
        scanner.close();
    }
}
