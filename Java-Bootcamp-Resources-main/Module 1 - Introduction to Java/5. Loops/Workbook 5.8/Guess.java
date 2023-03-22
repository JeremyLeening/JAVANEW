import java.util.Scanner;

public class Guess  {
    public static void main(String[] args) {

       System.out.print("I chose a number between 1 and 5. Try to guess it: ");
        
       Scanner scan = new Scanner(System.in);
       int random = (int) (Math.random() * 5);
       int guess = scan.nextInt();
       while (random != guess) {
        System.out.print("Your number is wrong guess again: ");
        guess = scan.nextInt();
       }
       System.out.println("You got it!");
        
        scan.close();
    }

}
