

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {
	
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
    private ListView<String> actionLog;

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


    void updateGUI(){
        if (Main.gameState.mentalHealth < 0) {
            mentalHealthBar.setProgress(0);
        } else {
            mentalHealthBar.setProgress(Main.gameState.mentalHealth / 100.0);
        }
        if (Main.gameState.food < 0) {
            foodBar.setProgress(0);
        } else {
            foodBar.setProgress(Main.gameState.food / 100.0);
        }
        moneyDisplay.setText(Main.gameState.getMoney());
        currTimeDisplay.setText(Main.gameState.getTime());
        currDayDisplay.setText(Main.gameState.day.toString());

        int timeLeftInDay = 1080 - Main.gameState.time;

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
            //TODO deal with losing the game
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
            //TODO things when game ends
        }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
