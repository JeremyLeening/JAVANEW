

public class Tax {
    public static void main(String[] args) {
        double[] price = {1.99, 2.99, 3.99, 4.99};

        for(int i = 0; i < price.length; i++){
        System.out.println("The original prices are:" + price[i]);
        System.out.println("The prices after tax are:" + (price[i]*1.13));
        }
    }
}
