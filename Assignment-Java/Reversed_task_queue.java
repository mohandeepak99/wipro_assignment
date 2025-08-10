import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
public class Reversed_task_queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 4 values:");
        LinkedList<String> ls =new LinkedList<>();
        for(int i=0;i<4;i++){
            String task =sc.nextLine();

            if(task.endsWith("!")){
                ls.addFirst(task);
            }
            else{
                ls.addLast(task);
            }
        }
        Collections.reverse(ls);

        System.out.println("Output ");
        
        for(String s : ls){
            System.out.println(s);
        }
    }
}
