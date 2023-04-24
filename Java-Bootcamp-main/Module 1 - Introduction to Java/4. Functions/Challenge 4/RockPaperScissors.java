import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");


        String checkPlay = scan.next();
        if (checkPlay.equals("yes")) {
            System.out.println("\nAllright!");
            System.out.println("\nChoose: rock, paper or scissors");            
            String userChoice = scan.next();
            String computerChoice = computerChoice();
            String result = result(userChoice, computerChoice);
            printResult(userChoice, computerChoice, result);
        } else {
            System.out.println("Darn, some other time...");
        }
        scan.close();

    }

    public static String computerChoice() {
        double randomNumber = Math.random() * 3;
        int integer = (int) randomNumber;


        switch (integer) {
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "";

        }
    }

    public static String result(String userChoice, String computerChoice) {
        String result = "";
        
        if (userChoice.equals("rock") && computerChoice.equals("scissors")) {
            result = "You win!";
        } else if (userChoice.equals("rock") && computerChoice.equals("paper")) {
            result = "You lose!";
        } else if (userChoice.equals("paper") && computerChoice.equals("rock")) {
            result = "You win!";
        } else if (userChoice.equals("paper") && computerChoice.equals("scissors")) {
            result = "You lose!";
        } else if (userChoice.equals("scissors") && computerChoice.equals("paper")) {
            result = "You win!";
        } else if (userChoice.equals("scissors") && computerChoice.equals("rock")) {
            result = "You lose!";
        } else if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } else {
            System.out.println("INVALID CHOICE");
            System.exit(0);
        }
        return result;
      }
 
      public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("\nYou chose:\t" + yourChoice);
        System.out.println("The computer chose:\t" + computerChoice);
        System.out.println(result);
    }

}
