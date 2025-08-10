import java.util.Scanner;
import java.util.Stack;

public class UndoStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> st =new Stack<>();

        System.out.println("Enter three values:");

        for(int i=0;i<3;i++){
            st.add(sc.nextLine());
        }

        String last = st.removeLast();

        st.addFirst(last);

        System.out.println("Printing stack contents in reverse");

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
