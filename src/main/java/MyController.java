

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

    }

    void checkGameLose(){

    }

    // EVENT HANDLERS -------------------------------------------------------------------

    void handleDoWork(ActionEvent e){
        Main.gameState.doWork();
        updateGUI();
        checkGameLose();
    }
    void handleGoClass(ActionEvent e){
        Main.gameState.gotoClass();
        updateGUI();
        checkGameLose();
    }
    void handleDoChores(ActionEvent e){
        Main.gameState.doChores();
        updateGUI();
        checkGameLose();
    }
    void handleDoHW(ActionEvent e){
        Main.gameState.doHomework();
        updateGUI();
        checkGameLose();
    }

    void handleWatchTv(ActionEvent e){
        Main.gameState.watchTV();
        updateGUI();
        checkGameLose();
    }

    void handleTakeNap(ActionEvent e){
        Main.gameState.takeNap();
        updateGUI();
        checkGameLose();
    }

    void handleGoWalk(ActionEvent e){
        Main.gameState.takeWalk();
        updateGUI();
        checkGameLose();
    }

    void handleCookMeal(ActionEvent e){
        Main.gameState.cookMeal();
        updateGUI();
        checkGameLose();
    }

    void handleOrderFood(ActionEvent e){
        Main.gameState.orderFood();
        updateGUI();
        checkGameLose();
    }

    void handleMakeSnack(ActionEvent e){
        Main.gameState.snack();
        updateGUI();
        checkGameLose();
    }

    void handleGotoSleep(ActionEvent e){
        Main.gameState.gotoSleep();
        updateGUI();
        checkGameLose();
        if(Main.gameState.gameEnded){
            //TODO things when game ends
        }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
