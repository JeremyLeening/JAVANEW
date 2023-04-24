public class WeatherNetwork {
    public static void main(String[] args) {

       
        
        int temp = 25;  

        String forecast;
        if (temp <= -1) {
            forecast = "FREEZING! Stay home!";
        } else if (temp <= 10) {
            forecast = "Cold. Wear a coat!";
        } else {
            forecast = "Warm. Go outside!";  
        }

        System.out.println(forecast);
    }
}
