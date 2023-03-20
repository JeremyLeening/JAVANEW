public class Calendar {
    public static void main(String[] args) {
        
        String day = "Saturday";
        System.out.println("Hey, are you free on " + day + "? \n");


        System.out.println("Let me check my calendar.");
        switch (day) {
            case "Monday": System.out.println("No!"); break;
            case "Tuesday": System.out.println("No!"); break;
            case "Wednesday": System.out.println("No!"); break;
            case "Thursday": System.out.println("No!"); break;
            case "Friday": System.out.println("No!"); break;
            case "Saturday": System.out.println("Yes!"); break;
            case "Sunday": System.out.println("Yes!"); break;
            default: System.out.println("that's not a day."); break;

    }
}
}