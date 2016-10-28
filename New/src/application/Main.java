package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	//static final String[] wordsstack_Advanced = new String[]{"ice","car","pen","game","ring"};

	
	
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
		
		AnchorPane pane = loader.load();
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
