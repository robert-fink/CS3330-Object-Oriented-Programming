/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Admin
 */
public class RwfwcbStopwatch extends Application {
    
    private ImageView hand;
    private Integer elapsedTime = 0; // seconds
    Timeline timeLine;
    private Integer seconds = 0;
    private Integer minutes = 0;
    private String s;
    private String m;
    Text txt1 = new Text();
    
    @Override
    public void start(Stage primaryStage) {
        ImageView clockFace = new ImageView();
        Image clockFaceImage = new Image(this.getClass().getResourceAsStream("clockface.png"));
        clockFace.setImage(clockFaceImage);
        
        hand = new ImageView();
        Image handImage = new Image(this.getClass().getResourceAsStream("hand.png"));
        hand.setImage(handImage);
        
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");
        
        HBox box1 = new HBox(10);
        box1.setAlignment(Pos.TOP_CENTER);
        box1.getChildren().addAll(start, stop, reset);
        box1.setPadding(new Insets(50, 10, 10, 10));
                
        HBox box2 = new HBox(10);
        box2.setAlignment(Pos.BOTTOM_CENTER);
        box2.setPadding(new Insets(10,10,50,10));
        txt1.setText("00 : 00");
        box2.getChildren().addAll(txt1);                
        
        StackPane root = new StackPane();
        root.getChildren().addAll(box2, box1, clockFace, hand);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        seconds = 1;
        
        s = String.format("%02d", seconds);
        m = String.format("%02d", minutes);
        
        timeLine = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> updateStopwatch() ));
        
        timeLine.setCycleCount(Animation.INDEFINITE);        
        
        start.setOnAction((ActionEvent event) -> {
            timeLine.play();
        });
        
        stop.setOnAction((ActionEvent event) -> {
            timeLine.stop();
        });
        
        reset.setOnAction((ActionEvent event) -> {
            hand.setRotate(0);
            timeLine.stop();
            elapsedTime = 0;
            minutes = 0;
            seconds=1;
            s = String.format("%02d", seconds);
            m = String.format("%02d", minutes);
            txt1.setText("00 : 00");
        });
    }
    
    public void updateStopwatch() {    
        txt1.setText(m + " : " + s);
        elapsedTime++;       
        Integer rotation = elapsedTime * 6;
        hand.setRotate(rotation);  
        seconds++;
        
        if (seconds==60){
            seconds=0;
            minutes++;
        }
        
        s = String.format("%02d", seconds);
        m = String.format("%02d", minutes);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
