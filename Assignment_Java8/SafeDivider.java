package Assignment_Java8;

import java.util.Optional;
import java.util.Scanner;

public class SafeDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();

        // Use Optional to safely divide
        Optional<Integer> result = (denominator == 0)
                ? Optional.empty()
                : Optional.of(numerator / denominator);

        // Print result or message if empty
        System.out.println(result.map(String::valueOf).orElse("Not Allowed"));
        scanner.close();
    }
}
