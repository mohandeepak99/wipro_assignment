package Assignment_Java8;

import java.util.Scanner;

@FunctionalInterface
interface Printer {
    void print(String message);
}

public class GreetingsPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your greeting message: ");
        String input = scanner.nextLine();

        // Lambda to implement functional interface
        Printer printer = msg -> System.out.println("Greeting: " + msg);

        // Pass function and message
        greet(printer, input);
        scanner.close();
    }

    public static void greet(Printer printer, String message) {
        printer.print(message);
    }
}
