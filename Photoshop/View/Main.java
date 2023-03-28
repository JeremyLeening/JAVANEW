import java.util.Scanner;
import Controller.Options;

public class Main {

public static void main(String[] args) {
    
    Options option = new Options();
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to the Photoshop store!");
    System.out.println("Type options for options: ");
    while(true){
    System.out.print("What would you like to do?: ");
    String choice = scan.nextLine();
    if(choice.equals("exit")){
        break;
    }
    option.choice(choice);
     
}
System.out.println("Thank you for shopping with us!");  
scan.close();
}
}