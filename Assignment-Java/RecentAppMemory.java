import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> ls = new LinkedList<>();

        System.out.println("Enter the apps, enter 'exit' to stop");

        while(true){

            String app = sc.nextLine();

            if(app.equalsIgnoreCase("exit")){
                break;
            }
            if(ls.contains(app)){
                ls.remove(app);
            }
            ls.addFirst(app);

            System.out.println("Recently used apps: "+ls);
        }
        System.out.println("Final apps in memory");
        for(String i : ls){
            System.out.println(i);
        }
    }
}
