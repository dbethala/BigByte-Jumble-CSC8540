package application;

import javafx.animation.AnimationTimer;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.sun.glass.ui.Window;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
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
	@FXML private Label bonushint;
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
	@FXML private GridPane gpBig;
	@FXML private Text timerField;
	@FXML private Text scoreField;
	@FXML private Button end;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button solveButton;
	@FXML private ImageView picture1;
	@FXML private ImageView picture2;
	@FXML private ImageView picture3;
	@FXML private Label difflabel, labelw1, labelw2, labelw3,labelw4, labelw5;
	@FXML private Label tfLabel1, tfLabel2, tfLabel3, tfLabel4, tfBonusWordLabel;
	private List<GridPane> grid = new ArrayList<GridPane>();
	

	int Hintcounter; // to keep track of the number of hints
	int score = 0;
	
	JumbleTimer timer;
    
	public void setMain(Main main){
	this.main=main; // now the main class is connected with the controller now i can call any method form the main.

	
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
	bonushint.getStyleClass().add("label");
	button2.getStyleClass().add("button");
	solveButton.getStyleClass().add("button");
	solveButton.setVisible(false);
	picture1.setVisible(false);
	picture2.setVisible(false);
	picture3.setVisible(false);
	bonushint.setVisible(false);
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
		easyRadioButton.setDisable(false);
		mediumRadioButton.setDisable(false);
		hardRadioButton.setDisable(false);
		button1.setDisable(false); // enabling the start
		button2.setDisable(true); // disabling the hint button
		Hintcounter=0; // So I work with hint button counter again
		
		if (easyRadioButton.isSelected() == true) 
                {
                    tf1.getStyleClass().add("initial");
                    tf7.getStyleClass().add("initial");
                    tf8.getStyleClass().add("initial");
                }
                 if (mediumRadioButton.isSelected() == true) 
                {
                    tf1.getStyleClass().add("initial");
                    tf4.getStyleClass().add("initial");
                    tf9.getStyleClass().add("initial");
                    tf13.getStyleClass().add("initial");
                }
                else if (hardRadioButton.isSelected() == true) 
                {
                    tf1.getStyleClass().add("initial");
                    tf4.getStyleClass().add("initial");
                    tf10.getStyleClass().add("initial");
                    tf15.getStyleClass().add("initial");
                    tf20.getStyleClass().add("initial");
                    tf22.getStyleClass().add("initial");
                }
		grid.add(gp1); grid.add(gp2);grid.add(gp3); grid.add(gp4);grid.add(gp5); // adding all the gridpanes to the gridArrayList 
		
		// This has to be before setting the radio button selection to falsae
		
		
		easyRadioButton.setSelected(false);
		mediumRadioButton.setSelected(false);
		hardRadioButton.setSelected(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		bonushint.setVisible(false);
		picture1.setVisible(false);
		picture2.setVisible(false);
		picture3.setVisible(false);
		scoreField.setText("0");
		if (!timer.stopped())
		    timer.stop(); 
		checkTextFields();
		
		
		TextField[] tfArray = { tf1, tf2, tf3, tf4, tf5, tf6,
		                        tf7, tf8, tf9, tf10, tf11, tf12,
		                        tf13, tf14, tf15, tf16, tf17, tf18,
		                        tf19, tf20, tf21, tf22, tf23, tf24,
		                        tf25, tf26, tf27, tf28, tf29, tf30};
		for (TextField tf : tfArray) 
		{
		    tf.setText("");
		}
	}

	
	

	public void handleButton(){
	        timer = new JumbleTimer(timerField);
		TextField[] tfArray = { tf1, tf2, tf3, tf4, tf5, tf6,
                tf7, tf8, tf9, tf10, tf11, tf12,
                tf13, tf14, tf15, tf16, tf17, tf18,
                tf19, tf20, tf21, tf22, tf23, tf24,
                tf25, tf26, tf27, tf28, tf29, tf30};
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		bonushint.setVisible(true);
		easyRadioButton.setDisable(true);
		mediumRadioButton.setDisable(true);
		hardRadioButton.setDisable(true);
		solveButton.setVisible(true);
		
		Label[] tfArr = {tfLabel1, tfLabel2, tfLabel3, tfLabel4, tfBonusWordLabel};
		for (Label tfLabel : tfArr) {
			tfLabel.setText("");
		}
		
		timer.start();


		button2.setDisable(false); // enabling the hint button again
		button1.setDisable(true); // disabling the start button
		end.setDisable(false);
		
		if (easyRadioButton.isSelected() == true) 
	        {
	            //System.out.println(easyRadioButton.isSelected());
		    tf1.getStyleClass().remove("initial");
		    tf7.getStyleClass().remove("initial");
		    tf8.getStyleClass().remove("initial");
		    tf1.getStyleClass().add("custom");
	            tf7.getStyleClass().add("custom");
	            tf8.getStyleClass().add("custom");
	            //System.out.println("End Easy");
	            
	            tfLabel3.setVisible(false);
	    		tfLabel4.setVisible(false);
	    		
	    		for(TextField tf : tfArray) {
	    			tf.setVisible(true);
	    		}
	    		
	    		//Hiding the last three text fields for gp1, gp2, and gp5
	    		tf4.setVisible(false);
	    		tf5.setVisible(false);
	    		tf6.setVisible(false);
	    		
	    		tf10.setVisible(false);
	    		tf11.setVisible(false);
	    		tf12.setVisible(false);
	    		
	    		tf28.setVisible(false);
	    		tf29.setVisible(false);
	    		tf30.setVisible(false);

	        }
	        else if (mediumRadioButton.isSelected() == true) 
	        {
	            //System.out.println(mediumRadioButton.isSelected());
	            tf1.getStyleClass().remove("initial");
	            tf4.getStyleClass().remove("initial");
                    tf9.getStyleClass().remove("initial");
                    tf13.getStyleClass().remove("initial");

	            tf1.getStyleClass().add("custom");
	            tf4.getStyleClass().add("custom");
	            tf9.getStyleClass().add("custom");
	            tf13.getStyleClass().add("custom");
	            //System.out.println("End Medium");
	            tfLabel3.setVisible(true);
	            tfLabel4.setVisible(false);
	            
	            for (TextField tf : tfArray) {
	            	tf.setVisible(true);
	            }
	            
	            //Making the unused textfields invisible
	            
	            //tf4.setVisible(true);
	            //tf5.setVisible(true);
	            tf6.setVisible(false);
	            //tf10.setVisible(true);
	            //tf11.setVisible(true);
	            tf12.setVisible(false);
	            //tf16.setVisible(true);
	            tf17.setVisible(false);
	            tf18.setVisible(false);
	            //tf28.setVisible(true);
	            tf29.setVisible(false);
	            tf30.setVisible(false);
	            
	        }
	        else if (hardRadioButton.isSelected() == true) 
	        {
	            //System.out.println(hardRadioButton.isSelected());
	            tf1.getStyleClass().remove("initial");
	            tf4.getStyleClass().remove("initial");
	            tf10.getStyleClass().remove("initial");
	            tf15.getStyleClass().remove("initial");
	            tf20.getStyleClass().remove("initial");
	            tf22.getStyleClass().remove("initial");
	            
	            tf1.getStyleClass().add("custom");
	            tf4.getStyleClass().add("custom");
	            tf10.getStyleClass().add("custom");
	            tf15.getStyleClass().add("custom");
	            tf20.getStyleClass().add("custom");
	            tf22.getStyleClass().add("custom");
	            //System.out.println("End Hard");
	            tfLabel3.setVisible(true);
	            tfLabel4.setVisible(true);
	            
	            
	            for (TextField tf : tfArray) {
	            	tf.setVisible(true);
	            }
	            
	            //Making the unused textfields invisible
	            
	            tf5.setVisible(false);
	            tf6.setVisible(false);
	            
	            tf12.setVisible(false);
	            
	            tf18.setVisible(false);
	            
	            tf23.setVisible(false);
	            tf24.setVisible(false);
	            
	        }
		
		Words word = new Words();
		
		//Generate Word set
		
		if(easyRadioButton.isSelected()==true){						
				for(int i = 0; i < wordsEasy.length; i++)
				{
					word.shuffleword(wordsEasy[i]);
					wordsEasy_NotArranged[i] = word.shuffleword(wordsEasy[i]);
				}
				label1.setText(wordsEasy_NotArranged[0]);	//set jumbled words
				label2.setText(wordsEasy_NotArranged[1]);	
		}
		
		if(mediumRadioButton.isSelected()==true){
			for(int i=0; i<wordsMedium.length;i++)
				
			{
				word.shuffleword(wordsMedium[i]);
				wordsMedium_NotArranged[i]=word.shuffleword(wordsMedium[i]);
			}
			
			label1.setText(wordsMedium_NotArranged[0]);
			label2.setText(wordsMedium_NotArranged[1]);
			label3.setText(wordsMedium_NotArranged[2]);
			}
		
		if(hardRadioButton.isSelected()==true){
			for(int i=0; i<wordsHard.length;i++)
				
			{
				word.shuffleword(wordsHard[i]);
				wordsHard_NotArranged[i]=word.shuffleword(wordsHard[i]);
			}
			
			label1.setText(wordsHard_NotArranged[0]);
			label2.setText(wordsHard_NotArranged[1]);
			label3.setText(wordsHard_NotArranged[2]);
			label4.setText(wordsHard_NotArranged[3]);
			}
		
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
			picture2.setVisible(false);
			picture3.setVisible(true);
		
		}
		
		if(hardRadioButton.isSelected()){
			picture1.setVisible(false);
			picture2.setVisible(false);
			picture3.setVisible(true);
			picture2.setVisible(true);
			picture3.setVisible(false);
			
		}
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		/////////////////// END OF PICTURE HANDLING/////////////////////
	        difficultyUI();									//set difficulty UI
		settextfield();									//call text field limit method
	}
	
	public EventHandler<KeyEvent> maxLength(final Integer i){	//event handler, limits text limit in whatever text field passed to it to 1
		return new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent arg0) {
				TextField tf = (TextField) arg0.getSource();
				if(tf.getText().length()>=i){
					arg0.consume();
				}
			}
		};
		
	}
	
	private void difficultyUI(){
		if(easyRadioButton.isSelected()==true){
			gpBig.getChildren().clear();						//cleared and re-added children to avoid errors 
			gpBig.getChildren().add(gp1);				//There might be a better way to do this
			gpBig.getChildren().add(gp2);
			gpBig.getChildren().add(gp5);
			gpBig.getChildren().add(labelw1);
			gpBig.getChildren().add(labelw2);
			gpBig.getChildren().add(labelw5);
			gpBig.getChildren().add(label1);
			gpBig.getChildren().add(label2);
			gpBig.getChildren().add(label5);
			
			
		}
		
		if(mediumRadioButton.isSelected()==true){
			gpBig.getChildren().clear();						//cleared and re-added children to avoid errors 
			gpBig.getChildren().add(gp1);				//There might be a better way to do this
			gpBig.getChildren().add(gp2);
			gpBig.getChildren().add(gp3);
			gpBig.getChildren().add(gp5);
			gpBig.getChildren().add(labelw1);
			gpBig.getChildren().add(labelw2);
			gpBig.getChildren().add(labelw3);
			gpBig.getChildren().add(labelw5);
			gpBig.getChildren().add(label1);
			gpBig.getChildren().add(label2);
			gpBig.getChildren().add(label3);
			gpBig.getChildren().add(label5);
		}
		
		if(hardRadioButton.isSelected()==true){
			gpBig.getChildren().clear();						//cleared and re-added children to avoid errors 
			gpBig.getChildren().add(gp1);				//There might be a better way to do this
			gpBig.getChildren().add(gp2);
			gpBig.getChildren().add(gp3);
			gpBig.getChildren().add(gp4);
			gpBig.getChildren().add(gp5);
			gpBig.getChildren().add(labelw1);
			gpBig.getChildren().add(labelw2);
			gpBig.getChildren().add(labelw3);
			gpBig.getChildren().add(labelw4);
			gpBig.getChildren().add(labelw5);
			gpBig.getChildren().add(label1);
			gpBig.getChildren().add(label2);
			gpBig.getChildren().add(label3);
			gpBig.getChildren().add(label4);
			gpBig.getChildren().add(label5);
		}
		
	}
	
	public void settextfield(){										//added event handler for each text field
		tf1.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf2.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf3.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf4.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf5.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf6.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf7.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf8.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf9.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf10.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf11.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf12.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf13.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf14.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf15.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf16.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf17.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf18.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf19.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf20.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf21.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf22.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf22.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf23.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf24.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf25.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf26.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf27.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf28.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf29.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));
		tf30.addEventHandler(KeyEvent.KEY_TYPED, maxLength(1));		
	}

	private String[] checkTextFields() {
		String level = verifyLevel();
		TextField [] tfArray = {tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9,
								tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17,
								tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25,
								tf26, tf27, tf28, tf29, tf30};
		//Building "character" arrays for each word
		TextField[] word1 = {tf1, tf2, tf3, tf4, tf5, tf6};
		TextField[] word2 = {tf7, tf8, tf9, tf10, tf11, tf12};
		TextField[] word3 = {tf13, tf14, tf15, tf16, tf17, tf18};
		TextField[] word4 = {tf19, tf20, tf21, tf22, tf23, tf24};
		TextField[] bonusWord = {tf25, tf26, tf27, tf28, tf29, tf30};
		
		//Array for the final Strings of the characters combined
		String[] builtWords = new String[5];
		
		//Placeholder for the bonus word
		String bonusWordBuilt = null;
		
		//Array of broken TextFields
		TextField[][] brokenWords = {word1, word2, word3, word4};
		
		//Loops through the TextFields array and builds the words, stores them in 
		//String array
		int i = 0;
		if (verifyLevel().equals("easy")) {
		for (i= 0; i < 2; i++) {
			builtWords[i] = wordBuilder(brokenWords[i]);
			}
		} else if (verifyLevel().equals("medium")) {
			for (i = 0; i < 3; i++) {
				builtWords[i] = wordBuilder(brokenWords[i]);
				}
		} else if (verifyLevel().equals("hard")) {
			for (i = 0; i < 4; i++) {
				builtWords[i] = wordBuilder(brokenWords[i]);
				}
		}
		
		//Separate function to handle the bonus word
		bonusWordBuilt = wordBuilder(bonusWord);
		builtWords[i] = bonusWordBuilt;
		
		return builtWords;
	}
	
	//Function to check and return level
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
	
	private boolean[] solutionChecker(String[] wordArray) {
		String difficultyLevel =  verifyLevel();
		boolean scoreArray[] = new boolean[wordArray.length + 1];
		switch (difficultyLevel) {
			case "easy":
				for (int i = 0; i < 3; i++) {
					int result = wordsEasy[i].compareToIgnoreCase(wordArray[i]);
					if (result == 0) {
						scoreArray[i] = true;
					} else {
						scoreArray[i] = false;
					}
				} break;
			case "medium":
				for (int i = 0; i < 4; i++) {
					int result = wordsMedium[i].compareToIgnoreCase(wordArray[i]);
					if (result == 0) {
						scoreArray[i] = true;
					} else {
						scoreArray[i] = false;
					}
				} break;
			case "hard":
				for (int i = 0; i < 5; i++) {
					int result = wordsHard[i].compareToIgnoreCase(wordArray[i]);
					if (result == 0) {
						scoreArray[i] = true;
					} else {
						scoreArray[i] = false;
				}
			}
		}
		return scoreArray;
	}
	
	//Function to build words from TextField arrays
	private String wordBuilder (TextField[] inputFields) {
		String builtWord = null;
		StringBuilder sb = new StringBuilder();
		for (TextField tf: inputFields)/*(int i = 0; i < inputFields.length; i++) */{
			//Does a preliminary check to see if an index is empty
				builtWord = sb.append(/*inputFields[i]*/tf.getCharacters()).toString();
			}
		return builtWord;
		}
	
	public void solvePuzzle() {
		Label[] labelsArray = {tfLabel1, tfLabel2, tfLabel3, tfLabel4, tfBonusWordLabel};
		boolean[] results = solutionChecker(checkTextFields());
		if (verifyLevel() == "easy") {
			for (int i = 0; i < 2; i++) {
				if(results[i]) {
					//System.out.println(labelsArray[i].getText());
					labelsArray[i].setText("Correct!");
				} else {
					labelsArray[i].setText("Incorrect!");
				}
			}
			if (results[2]) {
				tfBonusWordLabel.setText("Correct!");
			} else {
				tfBonusWordLabel.setText("Incorrect!");
			}
			if(results[0] && results[1] && results[2]){
				timer.stop();
				getScore();
			}
		} else if (verifyLevel() == "medium") {
			for (int i = 0; i < 3; i++) {
				if(results[i]) {
					//System.out.println(labelsArray[i].getText());
					labelsArray[i].setText("Correct!");
				} else {
					labelsArray[i].setText("Incorrect!");
				}
			}
			if (results[3]) {
				tfBonusWordLabel.setText("Correct!");
			} else {
				tfBonusWordLabel.setText("Incorrect!");
			}
			if(results[0] && results[1] && results[2] && results[3]){
				timer.stop();
				getScore();
			}
		} else if (verifyLevel() == "hard") {
			for (int i = 0; i < 4; i++) {
				if(results[i]) {
					//System.out.println(labelsArray[i].getText());
					labelsArray[i].setText("Correct!");
				} else {
					labelsArray[i].setText("Incorrect!");
				}
			}
			if (results[4]) {
				tfBonusWordLabel.setText("Correct!");
			} else {
				tfBonusWordLabel.setText("Incorrect!");
			}
			if(results[0] && results[1] && results[2] && results[3] && results[4]){
				timer.stop();
				getScore();
			}
		}
		
	}
	
	private void getScore() {
           int roundScore=0;
            boolean roundWon = true;
            int upperBound = 0;
           

            
            boolean[] results = solutionChecker(checkTextFields());
            
            if (verifyLevel() == "easy")
                upperBound = 3;
            else if (verifyLevel() == "medium")
                upperBound = 4;
            else if (verifyLevel() == "hard")
                upperBound = 5;
         
            
        
        	   for (int i = 0; i < upperBound; i++) {
                   if (results[i] == true) {
                       // SCORING RULE: +1 / Correct Word
                       roundScore+=1;
                   }
                   else {
                       roundWon = false;
                   }
               }
        	   
           
           
           
            // SCORING RULE: +10 for entire round
            if (roundWon == true){
                roundScore += 10;
            
            // SCORING RULE: 20 bonus points for avg. 1 min. / word solve
                int numberOfWords = upperBound;
            int elapsedTime = timer.getElapsedTime();
            int avgTimeToSolve = elapsedTime / numberOfWords;
            
            if (avgTimeToSolve <= 60)
                roundScore += 20;
            }
            score += roundScore;
            Integer scoreConversion = roundScore;
            scoreField.setText(scoreConversion.toString());
        }
	

}



