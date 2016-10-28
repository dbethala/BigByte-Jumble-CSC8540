package application;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javax.swing.Timer;

import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TimerTask;
import java.util.*;
public class Controller {
	

	static final String[] wordsstack_Advanced = new String[]{"READ","MOUSE","APPLE","NICE","SPIDER"};
	static final String[] wordsstack_Advanced_NotArranged = new String[wordsstack_Advanced.length];
	// first thing to do is to creat connection to the main class
	private Main main;
	// views
	@FXML private Label label; // same as the id i gave it in the scenebuilder
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private Label label3;
	@FXML private Label label4;

	@FXML private TextField field;
	@FXML private Text timerField;
	public void setMain(Main main){
	this.main=main; // now the main class is connected with the controller now i can call any method form the main	
	}
	
	
	
	public void handleButton(){
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		Words word= new Words();
		for(int i=0; i<wordsstack_Advanced.length;i++)
		{
		
			word.shuffleword(wordsstack_Advanced[i]);
			
			wordsstack_Advanced_NotArranged[i] = word.shuffleword(wordsstack_Advanced[i]); //saving each notarranged word into the not arranged stack
			System.out.println(word.shuffleword(wordsstack_Advanced[i]));
		}
		
		String text= field.getText();
		label1.setText(wordsstack_Advanced_NotArranged[0]);
		label2.setText(wordsstack_Advanced_NotArranged[1]);
		label3.setText(wordsstack_Advanced_NotArranged[2]);
		label4.setText(wordsstack_Advanced_NotArranged[3]);
		setTimer();
		field.clear();
		
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
				timerField.setText(difference.toString() + "s");	//Appends the "s" and prints time
			}
		}.start();
	}
}

