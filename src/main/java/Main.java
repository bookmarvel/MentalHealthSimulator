
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	static GameState gameState;
	@Override
	public void start(Stage primaryStage) {

		gameState = new GameState();
		 try {
	            // Read file fxml and draw interface.
	            Parent root = FXMLLoader.load(getClass()
	                    .getResource("/FXML/mainGamePage.fxml"));
	 
	            primaryStage.setTitle("Mental health simulation game");
             Scene s1 = new Scene(root, 1000,500);
             s1.getStylesheets().add("/styles/mainStyle.css");
	            primaryStage.setScene(s1);
	            primaryStage.show();
	         
	        } catch(Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
