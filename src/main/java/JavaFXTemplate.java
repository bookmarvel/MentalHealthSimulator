
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application{

	TextField text; 
	Button addToListBtn, sceneChangeBtn, b4,b5,b6,b7, printListBtn;  
	HashMap<String, Scene> sceneMap; 
	//GenericQueue<String> myQueue;
	EventHandler<ActionEvent> returnButtons;
	ListView<String> displayQueueItems;
	//use this to add and delete from ListView
	ObservableList<String> storeQueueItemsInListView;
	//use this for pausing between actions
	PauseTransition pause = new PauseTransition(Duration.seconds(3));
	//constant values java style
	static final int picHeight = 225;
	static final int picWidth = 200;

	MenuBar mainMenuBar;
	Menu menuFile;
	Menu menuOptions;
	Menu menuAbout;
	MenuItem menuItemNew;
	MenuItem menuItemOpen;


public static void main(String[] args) {

	launch(args);
}
 
public void start(Stage primaryStage) throws Exception {
	
	primaryStage.setTitle("JavaFx Scene change and ListView");
	
	text = new TextField();
	addToListBtn = new Button("Add to List");
	sceneChangeBtn = new Button("Change Scene");
	printListBtn = new Button("PrintList");
	sceneMap = new HashMap<String,Scene>();
	//stores strings: from your project #1
	//myQueue = new GenericQueue<String>(" ");
	displayQueueItems = new ListView<String>();
	//initialize to an observable list
	storeQueueItemsInListView = FXCollections.observableArrayList();


	mainMenuBar = new MenuBar();
	menuFile = new Menu("File");
	menuOptions = new Menu("Options");
	menuAbout = new Menu("About");

	menuItemNew = new MenuItem("New");
	menuItemOpen = new MenuItem("Open");
	menuFile.getItems().addAll(menuItemNew, menuItemOpen);

	mainMenuBar.getMenus().addAll(menuFile, menuOptions, menuAbout);
	
	//styling CSS way
	text.setStyle("-fx-font-size: 18;"+"-fx-border-size: 20;"+ 
			"-fx-border-color: purple;");
	
	displayQueueItems.setStyle("-fx-font-size: 25;"+"-fx-border-size: 20;"+ 
			"-fx-border-color: purple;");
	
	//using lambda for EventHandler: press enter adds info from text field to queue
	// text.setOnKeyPressed();
	
	//pause for 3 seconds then switch scene from picture buttons to original layout
	pause.setOnFinished(e->primaryStage.setScene(sceneMap.get("scene")));
	
	//this handler is used by multiple buttons 
	returnButtons = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			Button b = (Button)event.getSource();
			b.setDisable(true);
		//	primaryStage.setScene(sceneMap.get("scene"));
			pause.play(); //calls setOnFinished
		}
	};
	
	//add queue items to observable list and display inside ListView
	printListBtn.setOnAction(e-> {displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
								storeQueueItemsInListView.clear();
//								Iterator<String> i = myQueue.createIterator();
//								while(i.hasNext()) {
//									storeQueueItemsInListView.add(i.next());
//								}
								  displayQueueItems.setItems(storeQueueItemsInListView);});
	
							//add single strings: displayQueueItems.getItems().add("hello");
	
								
	sceneChangeBtn.setOnAction(e -> primaryStage.setScene(sceneMap.get("pics")));
	
	addToListBtn.setOnAction(new EventHandler<ActionEvent>(){
		
		public void handle(ActionEvent event){
			// myQueue.enqueue(text.getText());;
			text.clear();
			
		}
	});
	
	//two scenes returned from two methods; put in hashmap
	sceneMap.put("scene", createControlScene());
	sceneMap.put("pics", createPicScene());
	
	primaryStage.setScene(sceneMap.get("scene"));
	primaryStage.show();
	
	}

	//method to create our first scene with controls
	public Scene createControlScene() {
		
		BorderPane pane = new BorderPane();
		// pane.setPadding(new Insets(70));
		
		VBox paneCenter = new VBox(10, text, addToListBtn, printListBtn, displayQueueItems);
		
		pane.setCenter(paneCenter);
		pane.setLeft(sceneChangeBtn);
		pane.setStyle("-fx-background-color: lightPink;");

		pane.setTop(mainMenuBar);
		// BorderPane.setAlignment(mainMenuBar, Pos.TOP_LEFT); // doesn't do anything atm bc of padding?
		
		
		return new Scene(pane, 800, 700);
	}

	//method to create second scene with clickable buttons
	public Scene createPicScene() {
		
		Image pic = new Image("cozmo.jpg");
		ImageView v = new ImageView(pic);
		v.setFitHeight(picHeight);
		v.setFitWidth(picWidth);
		v.setPreserveRatio(true);
		
		Image pic2 = new Image("cozmo.jpg");
		ImageView v2 = new ImageView(pic2);
		v2.setFitHeight(picHeight);
		v2.setFitWidth(picWidth);
		v2.setPreserveRatio(true);
		
		Image pic3 = new Image("cozmo.jpg");
		ImageView v3 = new ImageView(pic3);
		v3.setFitHeight(picHeight);
		v3.setFitWidth(picWidth);
		v3.setPreserveRatio(true);
		
		Image pic4 = new Image("cozmo.jpg");
		ImageView v4 = new ImageView(pic4);
		v4.setFitHeight(picHeight);
		v4.setFitWidth(picWidth);
		v4.setPreserveRatio(true);
		
		b4 = new Button();
		b4.setOnAction(returnButtons);
		b4.setGraphic(v);
		b5 = new Button();
		b5.setOnAction(returnButtons);
		b5.setGraphic(v2);
		b6 = new Button();
		b6.setGraphic(v3);
		b6.setOnAction(returnButtons);
		b7 = new Button();
		b7.setGraphic(v4);
		b7.setOnAction(returnButtons);
		
		HBox root = new HBox(5, b7,b5,b6,b4);
		root.setStyle("-fx-background-color: lightblue;");
		
		return new Scene(root, 800,700);
		
	}
}

