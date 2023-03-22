import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) {

        String username = "Samantha";
        String password = "Java <3";
        

        Scanner scan = new Scanner(System.in);
        System.out.println("\nWelcome to Javagram! Sign in below\n");
        System.out.print("- Username: ");
        String user = scan.nextLine();
    
        System.out.print("- Password: ");
        String pass = scan.nextLine();
        while(!user.equals(username) && !pass.equals(password)){
        System.out.println("Wrong! Try again");
        System.out.print("- Username: ");
        user = scan.nextLine();
    
        System.out.print("- Password: ");
        pass = scan.nextLine();
        }
        System.out.println("Great you are logged in now.");
        
        
        /* will be useful for task 2
        
            System.out.println("\nIncorrect, please try again!\n");
            System.out.print("- Username: ");
            usernameEntry = scan.nextLine();
            System.out.print("- Password: ");
            passwordEntry = scan.nextLine();

        
        */
        scan.close();
        
    }
}
