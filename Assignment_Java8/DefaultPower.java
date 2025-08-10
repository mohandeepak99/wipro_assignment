package Assignment_Java8;

interface Power {
    void execute(); // abstract method

    default void defaultAction() {
        System.out.println("Executing default method.");
    }
}

public class DefaultPower {
    public static void main(String[] args) {
        // Lambda for abstract method
        Power p = () -> System.out.println("Executing abstract method.");

        p.execute();        // calls lambda (abstract)
        p.defaultAction();  // calls default method
    }
}
