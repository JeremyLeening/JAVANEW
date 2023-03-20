public class WorkSchedule {
    public static void main(String[] args) {
        
        int day = 3;  
        boolean holiday = true;

        if (holiday) {
            System.out.println("Holiday!, No work!");
        } else if (day == 6 || day == 7) {
            System.out.println("Weekend!, No work!");
        } else {
            System.out.println("Weekday!, Work!");
        }

        
        }

    }
