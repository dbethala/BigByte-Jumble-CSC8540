package application;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javax.swing.Timer;

import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;import java.awt.event.ActionEvent;
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

	@FXML private TextField tf1, tf2, tf3, tf4, tf5, tf6;
	@FXML private TextField tf7, tf8, tf9, tf10, tf11, tf12;
	@FXML private TextField tf13, tf14, tf15, tf16, tf17, tf18;
	@FXML private TextField tf19, tf20, tf21, tf22, tf23, tf24;
	@FXML private TextField tf25, tf26, tf27, tf28, tf29, tf30;
	
	@FXML private Text timerField;
	
	public void setMain(Main main){
	this.main=main; // now the main class is connected with the controller now i can call any method form the main	
	}
	
	public void handleButton(){
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		
		Words word = new Words();
		
		for(int i = 0; i < wordsHard.length; i++)
		{
			word.shuffleword(wordsHard[i]);
			
			wordsHard_NotArranged[i] = word.shuffleword(wordsHard[i]); //saving each notarranged word into the not arranged stack
			System.out.println(word.shuffleword(wordsHard[i]));
		}
		
		label1.setText(wordsHard_NotArranged[0]);
		label2.setText(wordsHard_NotArranged[1]);
		label3.setText(wordsHard_NotArranged[2]);
		label4.setText(wordsHard_NotArranged[3]);
		
		setTimer();
	}
	//Method to set timer. Implements AnimationTimer to spawn new thread to update UI
	private void setTimer() {
		new AnimationTimer(){
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
		}.start();
	}
}

