import java.util.ArrayDeque;
import java.util.Scanner;

public class Last3Searches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> searches = new ArrayDeque<>();

        System.out.println("Enter the 3 search values or enter 'exit' to stop");

        while (true) {
            
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("exit")){
                break;
            }
            if(searches.size()==3){
                searches.removeFirst();
            }
            searches.addLast(input);
            System.out.println("Current included searches "+searches);
        }

        System.out.println("Final searches are: "+searches);
    }
}
