import java.util.concurrent.BrokenBarrierException;

public class GameState {
    public enum DaysOfTheWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    DaysOfTheWeek day;
    int time;//Minutes since start of day
    int mentalHealth = 50; //Between 0-100 inclusive
    int food = 50; //Between 0-100 inclusive
    int money = 100;
    int hoursWorked;
    double hoursHomeworkDone;
    double hoursOfChoresDone;
    double hoursOfClassDone;
    boolean gameLost;
    boolean gameEnded;

    private void addFood(int newFood){
        this.food += newFood;
        if(this.food > 100) {
            this.food = 100;
        }
        else if(this.food <= 0){
            gameLost = true;
        }
    }
    private void addMentalHealth(int newHealth){
        this.mentalHealth += newHealth;
        if(this.mentalHealth > 100){
            this.mentalHealth = 100;
        }
        else if(this.mentalHealth <= 0){
            gameLost = true;
        }
    }

    private void addMoney(int newMoney){
        this.money += newMoney;
        if(this.money < 0){
            gameLost = true;
        }
    }

    public String getTime(){
        int minute = time % 60;
        int hour = (time / 60) + 6;
        boolean isAM = hour < 12;
        return hour % 12 + ":" + (minute < 10 ? "0" + minute: minute) + (isAM ? " am" : " pm");
    }

    public void gotoSleep(){
        int minutesSlept = 1440 - time;
        if(minutesSlept >= 480){
            addMentalHealth(20);
        }
        else{
            addMentalHealth(20 - ((480 - minutesSlept) / 3));
        }
        switch (day){
            case SUNDAY:
                day = DaysOfTheWeek.SUNDAY;
            case MONDAY:
                day = DaysOfTheWeek.TUESDAY;
                break;
            case TUESDAY:
                day = DaysOfTheWeek.WEDNESDAY;
                break;
            case WEDNESDAY:
                day = DaysOfTheWeek.THURSDAY;
                break;
            case THURSDAY:
                day = DaysOfTheWeek.FRIDAY;
                break;
            case FRIDAY:
                day = DaysOfTheWeek.SATURDAY;
                break;
            case SATURDAY:
                day = DaysOfTheWeek.SUNDAY;
                gameEnded = true;
                break;
        }
    }
    public void doHomework(){

    }

    public void doWork(){

    }
    public void doChores(){

    }
    public void gotoClass(){

    }
    public void watchTV(){

    }
    public void takeNap(){

    }
    public void takeWalk(){

    }
    public void cookMeal(){

    }
    public void orderFood(){

    }
    public void snack(){

    }
}
