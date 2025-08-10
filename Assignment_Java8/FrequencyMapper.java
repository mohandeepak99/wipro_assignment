package Assignment_Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter names with possible duplicates:");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        // Group and count occurrences
        Map<String, Long> frequencyMap = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Frequency Map: " + frequencyMap);
        scanner.close();
    }
}
