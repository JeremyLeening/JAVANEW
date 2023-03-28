package Model;


public class Open {
    //Class to represent the opening time for a certain day
    private int dayId; 
    private String dayName;
    private String openingTime;  
    private String closingTime;
    
    public Open(int dayId, String dayName, String openingTime, String closingTime){
        this.dayId = dayId;
        this.dayName = dayName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getAll(){
        return this.dayId + ": " + this.dayName + " " + this.openingTime + " - " + this.closingTime;
    }

    public int getDayId() {
        return this.dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return this.dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return this.closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    
}
