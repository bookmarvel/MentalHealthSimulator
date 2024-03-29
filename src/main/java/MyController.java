

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyController{
	
	@FXML
	private BorderPane root;

    // DISPLAYS -------------------------------------------------------------------------
    @FXML
    private HBox displaysHbox;

    @FXML
    private VBox left;

    @FXML
    private TextField currTimeText;

    @FXML
    private TextField currTimeDisplay;

    @FXML
    private
    TextField currDayDisplay;

    @FXML
    private VBox right;

    @FXML
    private TextField mentalHealthText;

    @FXML
    private ProgressBar mentalHealthBar;

    @FXML
    private TextField foodText;

    @FXML
    private ProgressBar foodBar;

    @FXML
    private TextField moneyDisplay;

    @FXML
    private TextField classLeftDisplay;

    @FXML
    private TextField homeworkLeftDisplay;

    @FXML
    private TextField choresLeftDisplay;

    @FXML
    private TextField jobLeftDisplay;

    // BUTTONS  -------------------------------------------------------------------------

    @FXML
    private HBox buttonLayer1;

    @FXML
    private Button bDoWork;

    @FXML
    private Button bGoClass;

    @FXML
    private Button bDoHW;

    @FXML
    private Button bDoChores;

    @FXML
    private HBox buttonLayer2;

    @FXML
    private Button bWatchTV;

    @FXML
    private Button bTakeNap;

    @FXML
    private Button bGoWalk;

    @FXML
    private HBox buttonLayer3;

    @FXML
    private Button bCookMeal;

    @FXML
    private Button bOrderFood;

    @FXML
    private Button bMakeSnack;

    @FXML
    private HBox buttonLayer4;

    @FXML
    private Button bGoSleep;


    // GAME END SCREEN  -----------------------------------------------------------------

    @FXML
    private BorderPane root2;

    @FXML
    private TextField gameEndHeader;

    @FXML
    private TextField gameEndStatus;

    @FXML
    private TextField scoreText;

    @FXML
    private TextField scoreDisplay;

    // GAME MANAGEMENT FUNCTIONS  -------------------------------------------------------

    //Update the GUI to reflect changes after completing a task
    void updateGUI(){
        mentalHealthBar.setProgress(Main.gameState.mentalHealth / 100.0);
        foodBar.setProgress(Main.gameState.food / 100.0);
        moneyDisplay.setText(Main.gameState.getMoney());
        currTimeDisplay.setText(Main.gameState.getTime());
        currDayDisplay.setText(Main.gameState.day.toString());
        classLeftDisplay.setText("Hours of class left in week: " + (15 - Main.gameState.hoursOfClassDone));
        homeworkLeftDisplay.setText("Hours of homework left in week: " + (30 - Main.gameState.hoursHomeworkDone));
        choresLeftDisplay.setText("Hours of chores left in week: " + (5 - Main.gameState.hoursOfChoresDone));
        jobLeftDisplay.setText("Hours of work left in week: " + (10 - Main.gameState.hoursWorked));

        int timeLeftInDay = 1080 - Main.gameState.time;
        //Disable buttons for tasks the user no longer has time to do in the day
        if (timeLeftInDay < 90){
            bCookMeal.setDisable(true);
        }
        if (timeLeftInDay < 60){
            bDoChores.setDisable(true);
            bDoHW.setDisable(true);
            bDoWork.setDisable(true);
            bGoClass.setDisable(true);
            bWatchTV.setDisable(true);
        }
        if (timeLeftInDay < 30){
            bOrderFood.setDisable(true);
            bTakeNap.setDisable(true);
            bGoWalk.setDisable(true);
        }
        if (timeLeftInDay < 15){
            bMakeSnack.setDisable(true);
        }
    }

    void checkGameLose(){
        if(Main.gameState.gameLost){
            Main.gameState.gameEnded = true;
            gameEnded();
        }
    }

    //Display the score and end scene when the game ends
    void gameEnded() {
        int score = Main.gameState.calculateScore();

        String status = "Game ended because ";

        if (Main.gameState.mentalHealth <= 0) {
            status = status + "you didn't take good enough care of your mental health";
        } else if (Main.gameState.food <= 0) {
            status = status + "you didn't eat enough food";
        } else if (Main.gameState.money <= 0) {
            status = status + "you ran out of money";
        } else {
            status = status + "you survived a week!";
        }

        //Change scene to game end scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gameEndScreen.fxml"));
            Parent newRoot = loader.load();

            root.getScene().setRoot(newRoot);
            newRoot.getScene().getStylesheets().add("/styles/mainStyle.css");

            MyController newController = loader.getController();

            newController.gameEndStatus.setText(status);

            newController.scoreDisplay.setText(String.valueOf(score));


        } catch (IOException e){
            System.out.println("Error: unable to load fxml file");
            e.printStackTrace();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    // EVENT HANDLERS -------------------------------------------------------------------

    public void handleDoWork(ActionEvent e){
        Main.gameState.doWork();
        updateGUI();
        checkGameLose();
    }
    public void handleGoClass(ActionEvent e){
        Main.gameState.gotoClass();
        updateGUI();
        checkGameLose();
    }
    public void handleDoChores(ActionEvent e){
        Main.gameState.doChores();
        updateGUI();
        checkGameLose();
    }
    public void handleDoHW(ActionEvent e){
        Main.gameState.doHomework();
        updateGUI();
        checkGameLose();
    }

    public void handleWatchTv(ActionEvent e){
        Main.gameState.watchTV();
        updateGUI();
        checkGameLose();
    }

    public void handleTakeNap(ActionEvent e){
        Main.gameState.takeNap();
        updateGUI();
        checkGameLose();
    }

    public void handleGoWalk(ActionEvent e){
        Main.gameState.takeWalk();
        updateGUI();
        checkGameLose();
    }

    public void handleCookMeal(ActionEvent e){
        Main.gameState.cookMeal();
        updateGUI();
        checkGameLose();
    }

    public void handleOrderFood(ActionEvent e){
        Main.gameState.orderFood();
        updateGUI();
        checkGameLose();
    }

    public void handleMakeSnack(ActionEvent e){
        Main.gameState.snack();
        updateGUI();
        checkGameLose();
    }

    public void handleGotoSleep(ActionEvent e){
        Main.gameState.gotoSleep();
        updateGUI();
        checkGameLose();

        //Reset all the buttons for the next day
        bCookMeal.setDisable(false);
        bDoChores.setDisable(false);
        bDoHW.setDisable(false);
        bDoWork.setDisable(false);
        bGoClass.setDisable(false);
        bWatchTV.setDisable(false);
        bOrderFood.setDisable(false);
        bTakeNap.setDisable(false);
        bGoWalk.setDisable(false);
        bMakeSnack.setDisable(false);

        if(Main.gameState.gameEnded){
           gameEnded();
        }
    }
}
