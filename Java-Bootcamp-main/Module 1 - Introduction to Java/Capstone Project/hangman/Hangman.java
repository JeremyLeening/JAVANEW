import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        
        boolean play = true;
        int count = 0;
       
        String chosenWord = randomWord();
        char [] emptyChosenWord = emptyChosenWord(chosenWord);
        char [] fullChosenWord = fullChosenWord(chosenWord);
        System.out.println("Welcome to Hangman!");
        System.out.println("================================");
        
        System.out.println("Your word to guess: "+Arrays.toString(emptyChosenWord));
        System.out.println("Your word to guess: "+Arrays.toString(fullChosenWord));
        
        while(play){
            	
            char letter = askLetter();
            if(!checkGuess(letter, chosenWord, emptyChosenWord, fullChosenWord)){
                count++;
            }
            
            System.out.println(gallows[count]);
            if (count == 6){
                play = false;
            }
            System.out.println(Arrays.toString(emptyChosenWord));
            if(Arrays.toString(emptyChosenWord).equals((Arrays.toString(fullChosenWord)))){
                System.out.println("You win!");
                play = false;
            }
        }
        if(count == 6){
        System.out.println("You lose!");
        System.out.println("The word was: "+chosenWord);
        }

    }

    public static char[] emptyChosenWord(String chosenWord) {

        char [] emptyChosenWord = new char[chosenWord.length()];
        for(int i = 0; i < chosenWord.length(); i++) {
            emptyChosenWord[i] = '_';
        
        }
        return emptyChosenWord;
    }
    public static char[] fullChosenWord(String chosenWord) {
        char [] fullChosenWord = new char[chosenWord.length()];
        for(int i = 0; i < chosenWord.length(); i++) {
            fullChosenWord[i] = chosenWord.charAt(i);
        }
        return fullChosenWord;
    }
    public static boolean checkGuess(char letter, String chosenWord, char [] emptyChosenWord, char [] fullChosenWord) {
        boolean check = false;
        for(int i = 0; i < chosenWord.length(); i++){
            if(letter == fullChosenWord[i]){
                emptyChosenWord[i] = letter;
                check = true;
            }
        }
        
        return check;
    }

    
    public static String randomWord() {
        return words[new Random().nextInt(words.length)];
    }

    public static char askLetter(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        return input.next().charAt(0);
    }        
}





