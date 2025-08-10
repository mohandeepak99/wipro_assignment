import java.util.ArrayDeque;
import java.util.Scanner;

public class LimitedChatHistory {
    public static void main(String[] args) {
        final int CAPACITY = 4;                 // keep only last 4
        ArrayDeque<String> history = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Type messages (type 'exit' to stop):");

        while (true) {
            String msg = sc.nextLine();
            if ("exit".equalsIgnoreCase(msg)) break;

            // if full, drop the oldest (front)
            if (history.size() == CAPACITY) {
                history.removeFirst();
            }

            // add newest to the back
            history.addLast(msg);

            // show current chat (oldest -> newest)
            System.out.println("Chat (last " + CAPACITY + "): " + history);
        }

        System.out.println("Final chat history: " + history);
        sc.close();
    }
}
