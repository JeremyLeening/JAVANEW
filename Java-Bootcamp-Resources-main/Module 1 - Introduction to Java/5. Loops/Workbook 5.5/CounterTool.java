import java.util.Scanner;

public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What increment do you want me to count by?: ");
        int increment = scan.nextInt();
        System.out.print("\nWhere do i start?: ");
        int start = scan.nextInt();
        System.out.print("\nWhere should i stop?: ");
        int stop = scan.nextInt();

        for(int i = start; i <= stop; i+=increment)
        System.out.print(i+" ");

       

        scan.close();
    }
}
