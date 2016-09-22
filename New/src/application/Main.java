package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	

	
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
	}
	
	public void mainWindow(){
	
	try {
		//primstage is the window itself but the scene is the content 
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml")); // if it did not work put/
		//FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("sample2.fxml")); // if it did not work put/
		AnchorPane pane = loader.load();
		//AnchorPane pane = loader2.load();
		Controller controllerobj = loader.getController();
		//Controller controllerobj = loader2.getController();
		controllerobj.setMain(this); // now whenever te main start it also call th method setMain from the controller class
		Scene scene = new Scene(pane); // scene take the pane as argument bcause pane load all the elements like buttons.etc
		
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Jumble Game");
		primaryStage.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	}
	
	public static void main(String[] args) {

		launch(args);
	}
}
