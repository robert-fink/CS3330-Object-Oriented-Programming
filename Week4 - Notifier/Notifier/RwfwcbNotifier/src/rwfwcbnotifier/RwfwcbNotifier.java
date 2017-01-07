/*
 * Robert Fink
 * rwfwcb
 */
package rwfwcbnotifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class RwfwcbNotifier extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField txt1 = new TextField();
        
        Button btn = new Button();
        btn.setText("Notify");
        btn.setOnAction((ActionEvent event) -> {
            txt1.setText("You have been notified!");
        });
        
        Button btn2 = new Button();
        btn2.setText("Clear");
        btn2.setOnAction((ActionEvent event) -> {
            txt1.setText("");
        });
               
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.add(txt1, 0, 0);
        root.add(btn, 1, 0);
        root.add(btn2, 1, 1);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}