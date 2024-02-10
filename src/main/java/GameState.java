public class GameState {
    public enum DaysOfTheWeek {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }
    DaysOfTheWeek day = DaysOfTheWeek.Sunday;
    int time;//Minutes since start of day
    int mentalHealth = 50; //Between 0-100 inclusive
    int food = 50; //Between 0-100 inclusive
    int money = 100;
    int hoursWorked;
    int hoursHomeworkDone;
    int hoursOfChoresDone;
    int hoursOfClassDone;
    boolean gameLost;
    boolean gameEnded;

    //Added food to the food meter, and checks for over/underflow
    private void addFood(int newFood){
        this.food += newFood;
        if(this.food > 100) {
            this.food = 100;
        }
        else if(this.food <= 0){
            this.food =0;
            gameLost = true;
        }
    }
    //Adds mental health to the mental health meeting and checks for over/underflow
    private void addMentalHealth(int newHealth){
        this.mentalHealth += newHealth;
        if(this.mentalHealth > 100){
            this.mentalHealth = 100;
        }
        else if(this.mentalHealth <= 0){
            this.mentalHealth = 0;
            gameLost = true;
        }
    }
    //Adds money and checks that money in not negative when amount added is negative
    private void addMoney(int newMoney){
        this.money += newMoney;
        if(this.money < 0){
            gameLost = true;
        }
    }

    //Calculates the amount of food that gets lost for a task the takes timeInteral minutes
    //Add subtracts that value from the food meter
    private void lossFoodOverTime(int timeInterval){
        addFood(timeInterval / -6);
    }

    //Calculates the score that gets displayed at the end of the game
    public int calculateScore(){
        int score = 0;
        score += mentalHealth * 5;
        score += food * 3;
        score += money;
        if(hoursWorked < 10){
            score -= (10 - hoursWorked) * 10;
        }
        if(hoursOfChoresDone < 5){
            score -= (5 - hoursOfChoresDone) * 10;
        }
        if(hoursOfClassDone < 15){
            score -= (15 - hoursOfClassDone) * 10;
        }
        if(hoursHomeworkDone < 30){
            score -= (30 - hoursHomeworkDone) * 10;
        }

        return score;
    }

    //Returns the current time of dally in a nicely formatted string to display to the user
    public String getTime(){
        int minute = time % 60;
        int hour = (time / 60) + 6;
        boolean isAM = hour < 12;
        return (hour <= 12 ? hour: hour -12) + ":" + (minute < 10 ? "0" + minute : minute) + (isAM ? " am" : " pm");
    }

    //Returns the money the player as in a formatted string to display to the user
    public String getMoney(){
        return "$" + this.money + ".00";
    }

    //Performs the needed calculations for going to sleep and update the class variables
    public void gotoSleep(){
        int minutesSlept = 1440 - time;
        if(minutesSlept >= 480){
            addMentalHealth(20);
        }
        else{
            addMentalHealth(20 - ((480 - minutesSlept) / 3));
        }
        this.time = 0;
        lossFoodOverTime(minutesSlept / 2);
        switch (day){
            case Sunday:
                day = DaysOfTheWeek.Monday;
                break;
            case Monday:
                day = DaysOfTheWeek.Tuesday;
                break;
            case Tuesday:
                day = DaysOfTheWeek.Wednesday;
                break;
            case Wednesday:
                day = DaysOfTheWeek.Thursday;
                break;
            case Thursday:
                day = DaysOfTheWeek.Friday;
                break;
            case Friday:
                day = DaysOfTheWeek.Saturday;
                break;
            case Saturday:
                day = DaysOfTheWeek.Sunday;
                gameEnded = true;
                break;
        }
    }
    //Functions for updating class variables when the user finishes a task
    public void doHomework(){
        this.hoursHomeworkDone += 1;
        this.time += 60;
        lossFoodOverTime(60);
        addMentalHealth(-15);
    }

    public void doWork(){
        this.hoursWorked += 1;
        this.time += 60;
        lossFoodOverTime(60);
        addMentalHealth(-20);
        addMoney(15);
    }
    public void doChores(){
        this.hoursOfChoresDone += 1;
        this.time += 60;
        lossFoodOverTime(60);
        addMentalHealth(-5);
    }
    public void gotoClass(){
        this.hoursOfClassDone += 1;
        this.time += 60;
        lossFoodOverTime(60);
        addMentalHealth(-10);
    }
    public void watchTV(){
        this.time += 60;
        lossFoodOverTime(60);
        addMentalHealth(25);
    }
    public void takeNap(){
        this.time += 30;
        lossFoodOverTime(30);
        addMentalHealth(10);
    }
    public void takeWalk(){
        this.time += 30;
        lossFoodOverTime(30 * 2);
        addMentalHealth(20);
    }
    public void cookMeal(){
        this.time += 90;
        addFood(60);
        addMentalHealth(20);
        addMoney(-5);
    }
    public void orderFood(){
        this.time += 30;
        addFood(60);
        addMoney(-20);
    }
    public void snack(){
        this.time += 15;
        addFood(15);
        addMoney(-5);
    }
}
