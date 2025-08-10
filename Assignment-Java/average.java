import java.util.Scanner;
public class average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] =new int[5];
        int sum=0;
        System.out.println("enter five numbers");

        for(int i=0;i<5;i++){
            arr[i]= sc.nextInt();

            if(arr[i]<10){
                arr[i]*=2;
            }
            sum+=arr[i];
        }
        double avgerage = (double)sum/arr.length;
        System.out.println("The avg of 5 numbers entered is: "+avgerage);
    }
}
