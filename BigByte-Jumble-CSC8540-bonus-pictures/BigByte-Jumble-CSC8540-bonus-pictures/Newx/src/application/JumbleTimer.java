package application;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class JumbleTimer extends AnimationTimer {
    private long startTime; //Variable to hold system time
    private int elapsedTime;
    private boolean stoppedFlag;
    @FXML private Text timerField;
    

    public JumbleTimer(Text timerField2) {
        timerField = timerField2;
    }

    @Override
    public void start() {
            startTime = System.currentTimeMillis(); //Sets system time in milliseconds
            super.start();  //Starts the thread
            stoppedFlag = false;
    }
    
    @Override
    public void stop(){
            super.stop();
            stoppedFlag = true;
            long now = System.currentTimeMillis();
            elapsedTime = (int)(now-startTime)/1000;
    }
    
    @Override
    public void handle(long timestamp) {
            long now = System.currentTimeMillis();  //Gets current time after thread has started
            Long difference = (now-startTime)/1000; //1000 milliseconds in one second
            timerField.setText(difference.toString() + "s");        //Appends the "s" and prints time in seconds
    }
    
    public int getElapsedTime() {
        
        return elapsedTime;
    }
    
    public boolean stopped() {
        return stoppedFlag;
    }
}
