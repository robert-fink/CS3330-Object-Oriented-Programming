/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * Robert Fink
 */
public class FXMLStopwatchController implements Initializable {
    
    private Integer seconds = 0;
    private Integer minutes = 0;
    private Integer elapsedTime = 0;
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView hand;
    
    @FXML
    private ImageView dial;
    
    private final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> updateStopwatch() ));
        
    @FXML
    private void handleStart(ActionEvent e){
        timeline.setCycleCount(Animation.INDEFINITE); 
        timeline.play();
    }
    
    @FXML
    private void handleStop(ActionEvent e){
        timeline.stop();
    }
    
    @FXML
    private void handleReset(ActionEvent e){
        timeline.stop();
        hand.setRotate(0);
        elapsedTime = 0;
        minutes = 0;
        seconds = 0;
        label.setText(String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
    }
        
    private void updateStopwatch() {  
        Integer rotation;
        seconds++;
        elapsedTime++;
        label.setText(String.format("%02d", minutes) + " : " + String.format("%02d", seconds));      
        rotation = elapsedTime * 6;
        hand.setRotate(rotation);  
        if (seconds==60){
            seconds=0;
            minutes++;
        }
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
