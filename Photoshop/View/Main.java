import java.util.Scanner;
import Controller.Options;

public class Main {

public static void main(String[] args) {
    //Creating a Options object to manage the chosen options
    Options option = new Options();
    //Creating a Scanner object to read user input
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to the Photoshop store!");
    System.out.println("Type options for options: ");
    //While loop to stay in the Photostore
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