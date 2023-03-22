public class Receipt {
    public static void main(String[] args) {

        String[] apples = {"Granny Smith", "Royal Gala","Red Deliciouse"};
        double[] prices = {1.25,1.50,1.75};
        System.out.println("Here's your receipt:\n");
        
        
        for(int i = 0; i < apples.length; i++){
        System.out.println("\t"+apples[i]+ ": $"+prices[i]);
        }

    }
}
