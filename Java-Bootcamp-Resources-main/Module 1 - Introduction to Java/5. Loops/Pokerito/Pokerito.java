import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Pokerito. Type anything when you're ready!: ");
        scan.nextLine();
        System.out.println("It's like Poker, but a lot simpler\n");
        System.out.println(" - There are two players, you and the computer.");
        System.out.println(" - The dealer will give each player one card.");
        System.out.println(" - Then, the dealer will draw five cards (the river)");
        System.out.println(" - The player with the most river matches wins! ");
        System.out.println(" - If the matches are equal, everyone's a winner!\n");
        System.out.println(" - Ready? Type anything if you are!: ");

        
        scan.nextLine();
        String yourCard = randomCard();
        String computerCard = randomCard();
        System.out.println("\nYour card is: " + yourCard);
        System.out.println("\nThe Computer's card is: " + computerCard);

        int yourMatches = 0;
        int computerMatches =0;

        for(int i=0; i<5; i++){
            String riverCard = randomCard();
            System.out.println("River draws: " + riverCard);
            if(yourCard.equals(riverCard)){
                yourMatches++;
            }
            if(computerCard.equals(riverCard)){
                computerMatches++;
            }
            System.out.println("Ready for next card? Type anything if you are!: ");
            scan.nextLine();
        }
        if(yourMatches>=computerMatches){
            System.out.println("You win with a score of: " + yourMatches);
        }
        if(computerMatches>=yourMatches){
            System.out.println("The computer wins with a score of: " + computerMatches);
        }
        if(computerMatches==yourMatches){
            System.out.println("Everyone wins!");
        }
      

         scan.close();
    }

    public static String randomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        switch ((int)randomNumber) {
            case 1:   
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____A|\n";
            case 2:
            return  "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____2|\n";
                  
            case 3:
            return"   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____3|\n";

            case 4:
            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____4|\n";

            case 5:
            return  "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____5|\n";

            case 6:
            return  "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            case 7:
            return  
                    "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
          

            case 8:
            return  "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:
            return  "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";

            case 10:
            return  "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:
            return  "   _____\n" +
                    "  |J    |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |0 0  |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |____J|\n";
            case 12:
            return  "   _____\n" +
                    "  |Q    |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |0 0  |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |____Q|\n";
            case 13:
            return  "   _____\n" +
                    "  |K    |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |0 0  |\n"+ 
                    "  | 0 0 |\n"+ 
                    "  |____K|\n";
            default: 
            return "This shouldn't get called.";
                }
                
    }
}
