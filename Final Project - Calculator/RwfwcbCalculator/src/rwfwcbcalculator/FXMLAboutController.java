/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbcalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 *
 * @author Robert Fink
 */
public class FXMLAboutController extends Switchable implements Initializable{
    
    ArrayList<String> sceneList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sceneList = new ArrayList();
        sceneList.add("FXMLScientificCalculator");
        sceneList.add("FXMLCalculator");
        sceneList.add("FXMLAbout");
    } 
    
    
    @FXML
    private void handleGoToScientificCalculator(ActionEvent event) {
        switchTo(sceneList.get(0));
    }
    
    @FXML
    private void handleGoToCalculator(ActionEvent event) {
        switchTo(sceneList.get(1));
    }
    
    @FXML
    private void handleGoToAbout(ActionEvent event) {
        switchTo(sceneList.get(2));
    }

}
