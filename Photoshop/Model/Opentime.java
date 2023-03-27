package Model;

import java.util.Date;

public class Opentime {
    
    private int dayId; 
    private String dayName;
    private Date openingTime;  
    private Date closingTime;
    
    public Opentime(int dayId, String dayName, Date openingTime, Date closingTime){
        this.dayId = dayId;
        this.dayName = dayName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
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

    public Date getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return this.closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    
}
