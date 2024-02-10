public class GameState {
    public enum WeekDay {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    WeekDay day;
    int time;//Minutes since start of day
    int mentalHealth; //Between 0-100 inclusive
    int food; //Between 0-100 inclusive
    int money;
    int hoursWorked;
    double hoursHomeworkDone;
    double hoursOfChoresDone;
    double hoursOfClassDone;
    boolean gameLost;

    private void addFood(int newFood){
        this.food += newFood;
        if(this.food > 100) {
            this.food = 100;
        }
        else if(this.food < 0){
            gameLost = true;
        }
    }
    private void addMentalHealth(int newHealth){
        this.mentalHealth += newHealth;
        if(this.mentalHealth > 100){
            this.mentalHealth = 100;
        }
        else if(this.mentalHealth < 0){
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
