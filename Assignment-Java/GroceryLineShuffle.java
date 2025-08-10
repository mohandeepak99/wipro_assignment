import java.util.ArrayDeque;
import java.util.Scanner;
import java.lang.String;

public class GroceryLineShuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> ad =new ArrayDeque<>();

        System.out.println("Enter your name or type 'exit' to stop");

        while(true){

            String name  =sc.nextLine();
            if(name.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Currently people in queue");
            if(name.length()%2 == 0){
                ad.addFirst(name);
            }
            else{
                ad.addLast(name);
            }
            System.out.println(ad);
        }

        System.out.println("Final order is : ");

        for(String i : ad){
            System.out.println(i);
        }
    }
}
