package application;

import javafx.animation.AnimationTimer;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.sun.glass.ui.Window;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.Component;
import java.awt.Container;
import java.awt.TextComponent;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TimerTask;
import java.util.*;

public class Controller {
	static final String[] wordsEasy = new String[]{"HAT", "MAP", "HAM"};
	static final String[] wordsEasy_NotArranged = new String[wordsEasy.length];
	
	static final String[] wordsMedium = new String[]{"WHALE", "GRASS", "LAND", "WALL"};
	static final String[] wordsMedium_NotArranged = new String[wordsMedium.length];
    
        static final String[] wordsHard = new String[]{"READ","MOUSE","APPLE","NICE","SPIDER"};
	static final String[] wordsHard_NotArranged = new String[wordsHard.length];
	
	// First thing to do is to create connection to the main class
	private Main main;
	// Views
	@FXML private Label label; // same as the id i gave it in the scenebuilder
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private Label label3;
	@FXML private Label label4;
	@FXML private Label label5;
	@FXML private Label hintnum;
	@FXML private RadioButton easyRadioButton; //iteration 4
	@FXML private RadioButton mediumRadioButton; //iteration 4
	@FXML private RadioButton hardRadioButton;	//iteration 4
	@FXML private TextField tf1, tf2, tf3, tf4, tf5, tf6;
	@FXML private TextField tf7, tf8, tf9, tf10, tf11, tf12;
	@FXML private TextField tf13, tf14, tf15, tf16, tf17, tf18;
	@FXML private TextField tf19, tf20, tf21, tf22, tf23, tf24;
	@FXML private TextField tf25, tf26, tf27, tf28, tf29, tf30;
	@FXML private GridPane gp1; // iteration 4
	@FXML private GridPane gp2; // iteration 4
	@FXML private GridPane gp3; // iteration 4
	@FXML private GridPane gp4; // iteration 4
	@FXML private GridPane gp5; // iteration 4
	@FXML private Text timerField;
	@FXML private Button end;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private ImageView picture1;
	@FXML private ImageView picture2;
	@FXML private ImageView picture3;
	@FXML private Label difflabel, labelw1, labelw2, labelw3,labelw4, labelw5;
	private List<GridPane> grid = new ArrayList<GridPane>();
	int Hintcounter; // to keep track of the number of hints
    
	public void setMain(Main main){
	this.main=main; // now the main class is connected with the controller now i can call any method form the main.

	//tf1.getStyleClass().add("custom"); HIGHLIGHTS WOWWWWWWW
	easyRadioButton.getStyleClass().add("custom1");
	mediumRadioButton.getStyleClass().add("custom1");
	hardRadioButton.getStyleClass().add("custom1");
	hintnum.getStyleClass().add("custom1");
	difflabel.getStyleClass().add("custom1");
	timerField.getStyleClass().add("custom1");
	label1.getStyleClass().add("custom1");
	label2.getStyleClass().add("custom1");
	label3.getStyleClass().add("custom1");
	label4.getStyleClass().add("custom1");
	label5.getStyleClass().add("custom1");
	labelw1.getStyleClass().add("label");
	button2.getStyleClass().add("button");
	
	picture1.setVisible(false);
	picture2.setVisible(false);
	picture3.setVisible(false);
	button2.setDisable(true);  // disabling the click on hint when you load the game 
	end.setDisable(true); // disabling the click on endgame when you load the game 
	
	}
	
	public void HintButtonHandler(){
		Hintcounter++; // keeping track of how many times I clicked on the Hint Button
		if (easyRadioButton.isSelected()==true){
			
				if (Hintcounter==1){
					tf1.setText("H");	
					hintnum.setText("One Hint Left");
				}
				if (Hintcounter==2){
					tf7.setText("M");
					button2.setDisable(true); // On easy level only Two hints, so Hint Button Disabled after second time
					hintnum.setText("You Are Out Of Hints!");
				}
				
				
		}
		else if (mediumRadioButton.isSelected()==true){
			if (Hintcounter==1){tf1.setText("W");hintnum.setText("Two Hints Left");}
			if (Hintcounter==2){tf7.setText("G");hintnum.setText("One Hint Left");}
			if (Hintcounter==3){tf13.setText("L");
			button2.setDisable(true);
			hintnum.setText("You Are Out Of Hints!");}
			
		}
		else {
			if (Hintcounter==1){tf1.setText("R");hintnum.setText("Three Hints Left");}
			if (Hintcounter==2){tf7.setText("M");hintnum.setText("Two Hints Left");}
			if (Hintcounter==3){tf13.setText("A");hintnum.setText("One Hint Left");}
			if (Hintcounter==4){tf19.setText("N");
			button2.setDisable(true);
			hintnum.setText("You Are Out Of Hints!");}
			
		}
	}
	
	public void endGame(){
		button1.setDisable(false); // enabling the start
		button2.setDisable(true); // disabling the hint button
		Hintcounter=0; // So I work with hint button counter again
		
	
		grid.add(gp1); grid.add(gp2);grid.add(gp3); grid.add(gp4);grid.add(gp5); // adding all the gridpanes to the gridArrayList 
		easyRadioButton.setSelected(false);
		mediumRadioButton.setSelected(false);
		hardRadioButton.setSelected(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		picture1.setVisible(false);
		picture2.setVisible(false);
		picture3.setVisible(false);
		timer.stop();
		checkTextFields();
		for(GridPane x : grid){ //adding all the text field elements of each grid to textfield arraylist so I can clear them at once
			for (Node node : x.getChildren()) {
			    System.out.println("Id: " + node.getId());
			    if (node instanceof TextField) {
			        // clear
			        ((TextField)node).setText("");
			    }
			}
		}
	
	}
	

	public void handleButton(){
		
		button2.setDisable(false); // enabling the hint button again
		button1.setDisable(true); // disabling the start button
		end.setDisable(false);
		Words word = new Words();
		
		for(int i = 0; i < wordsHard.length; i++)
		{
			word.shuffleword(wordsHard[i]);
			
			wordsHard_NotArranged[i] = word.shuffleword(wordsHard[i]); //saving each Notarranged word into the not arranged stack
			
			//System.out.println(word.shuffleword(wordsHard[i])); We don't need this
		}
		
		label1.setText(wordsHard_NotArranged[0]);
		label2.setText(wordsHard_NotArranged[1]);
		label3.setText(wordsHard_NotArranged[2]);
		label4.setText(wordsHard_NotArranged[3]);
		/////////////	THIS PART FOR THE PICTURE ///////////////
		if(easyRadioButton.isSelected()){
			picture1.setVisible(true);
			picture2.setVisible(false);
			picture3.setVisible(false);
			
			
		}
		if(mediumRadioButton.isSelected()){
			picture1.setVisible(false);
			picture2.setVisible(true);
			picture3.setVisible(false);
		
		}
		if(hardRadioButton.isSelected()){
			picture1.setVisible(false);
			picture2.setVisible(false);
			picture3.setVisible(true);
			
		}
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		/////////////////// END OF PICTURE HANDLING/////////////////////
			timer.start();
		
		
	}
	//Method to set timer. Implements AnimationTimer to spawn new thread to update UI
	AnimationTimer timer = new AnimationTimer() {
		private long startTime; //Variable to hold system time
		
		@Override
		public void start() {
			startTime = System.currentTimeMillis();	//Sets system time in milliseconds
				super.start();	//Starts the thread
		}
		
		@Override
		public void stop(){
			super.stop();
		}
		
		@Override
		public void handle(long timestamp) {
			// TODO Auto-generated method stub
			long now = System.currentTimeMillis();	//Gets current time after thread has started
			Long difference = (now-startTime)/1000;	//1000 milliseconds in one second
			timerField.setText(difference.toString() + "s");	//Appends the "s" and prints time in seconds
		}
	};
	
	private void checkTextFields() {
		String level = verifyLevel();
		switch(level) {
			case "easy":
				
		}
	}
	
	private String verifyLevel() {
		String level = "Level not selected";

		if (easyRadioButton.isSelected()) {
			level = "easy";
		} else if (mediumRadioButton.isSelected()) {
			level = "medium";
		} else if (hardRadioButton.isSelected()) {
			level = "hard";
		}
		return level;
	}
	private String wordBuilder (TextField[] inputFields) {
		String builtWord = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (!inputFields[i].getCharacters().equals(null)) {
				builtWord = sb.append(inputFields[i].getCharacters()).toString();
			}
		}
		return builtWord;
	}
}


