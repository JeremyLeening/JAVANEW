import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    CSVFileReader reader = new CSVFileReader("_resources/PhotoShop_PriceList.csv", ",");
    reader.read();
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to the Photoshop store!");
    System.out.println("What would you like to do");
    String choice = scan.nextLine();
    

    

    scan.close();
}

}