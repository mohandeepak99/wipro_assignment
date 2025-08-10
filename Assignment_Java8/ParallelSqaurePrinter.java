package Assignment_Java8;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelSqaurePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers separated by space:");
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        System.out.println("Squares printed in parallel:");
        numbers.parallelStream()
               .forEach(n -> System.out.println("Square of " + n + " is " + (n * n)));

        scanner.close();
    }
}
