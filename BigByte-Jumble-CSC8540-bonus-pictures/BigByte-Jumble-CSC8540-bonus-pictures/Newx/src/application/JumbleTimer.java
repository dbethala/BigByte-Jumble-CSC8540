package application;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class JumbleTimer extends AnimationTimer {
    private long startTime; //Variable to hold system time
    @FXML private Text timerField;

    public JumbleTimer(Text timerField2) {
        timerField = timerField2;
    }

    @Override
    public void start() {
            startTime = System.currentTimeMillis(); //Sets system time in milliseconds
            super.start();  //Starts the thread
    }
    
    @Override
    public void stop(){
            super.stop();
    }
    
    @Override
    public void handle(long timestamp) {
            long now = System.currentTimeMillis();  //Gets current time after thread has started
            Long difference = (now-startTime)/1000; //1000 milliseconds in one second
            timerField.setText(difference.toString() + "s");        //Appends the "s" and prints time in seconds
    }
    
    public int getElapsedTime() {
        long now = System.currentTimeMillis();
        long elapsedTime = (now-startTime)/1000;
        return (int)elapsedTime;
    }
}
