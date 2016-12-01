package application;
	
import java.awt.SplashScreen;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	//static final String[] wordsstack_Advanced = new String[]{"ice","car","pen","game","ring"};

	
	
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
		
		final SplashScreen splash = SplashScreen.getSplashScreen();
		if (splash != null) {
	        System.out.println("Closing splashscreen...");
	        splash.close();
	    }
		
	}
	
	public void mainWindow(){
		primaryStage.setTitle("Jumble Game"); // added a title to the stage.
		
		
	try {
		//primstage is the window itself but the scene is the content 
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml")); // if it did not work put/
		
		AnchorPane pane = loader.load();
		//pane.setStyle("-fx-background-color: red");
		Controller controllerobj = loader.getController();
		controllerobj.setMain(this); // now whenever te main start it also call th method setMain from the controller class
		Scene scene = new Scene(pane); // scene take the pane as argument bcause pane load all the elements like buttons.etc
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	}
	
	public static void main(String[] args) {
//		Words word= new Words();
//		for(int i=0; i<wordsstack_Advanced.length;i++)
//		{
//		
//			word.shuffleword(wordsstack_Advanced[i]);
//			System.out.println(word.shuffleword(wordsstack_Advanced[i]));
//		}
	
		launch(args);
		
	}
	
}

