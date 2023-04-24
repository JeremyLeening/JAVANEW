import java.util.Scanner;

public class Blackjack {

        public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scanner.nextLine();
        int card1 = 1;
        int card2 = drawRandomCard();

        int total = cardValue(card1) + cardValue(card2);
        if (card1 == 1 && card2 == 1){
                card2 = 14;
                total = total-10;
        }
        System.out.println("You get: \n" + numberCard(card1) + "\nand\n" + numberCard(card2));
        System.out.println("You have a total of: " + total);

        String testHit = "";
        testHit = toHitOrStay();
        while(!testHit.equals("stay")){
                   
                int newcard = drawRandomCard();
                total += cardValue(newcard);
                
                System.out.println("You drew: "+ numberCard(newcard));
 
                if(total>21 && card1 == 1){
                        card1 = 14;
                        total = total-10;
                }
                if(total>21 && card2 == 1){
                        card2 = 14;
                        total = total-10;
                }
                System.out.println("Your total is: " + total);
                if(total > 21){
                        System.out.println("You lost!");
                        break;
                }  
                testHit = toHitOrStay();
                
        }
        
       

         scanner.close();

    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int)randomNumber;
    }

    public static int cardValue(int card) {
        int value = 0;
        switch(card){
            case 1:
            return value = 11;
            case 2:
            return value = 2;
            case 3:
            return value = 3;            
            case 4:
            return value = 4;            
            case 5:
            return value = 5;            
            case 6:
            return value = 6;            
            case 7:
            return value = 7;           
            case 8:
            return value = 8;            
            case 9:
            return value = 9;            
            case 10:
            return value = 10;
            case 11:
            return value = 10;
            case 12:
            return value = 10;
            case 13:
            return value = 10;
            case 14:
            return value = 1;
        }
        return value;
    }

    public static String numberCard(int number) {
        
        switch (number) {
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

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    public static String toHitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String response = scanner.nextLine();

        while (!(response.equals("hit") || response.equals("stay"))) {
            System.out.println("Please write hit or stay");
            response = scanner.nextLine();
        }
        return response;
    }
    }

