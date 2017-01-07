/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;
import java.util.ArrayList;

/**
 *
 * @author Robert Fink
 */
public class FXMLScientificCalculatorController extends FXMLCalculatorController {   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        answer = new Answer();
        sceneList = new ArrayList();
        sceneList.add("FXMLScientificCalculator");
        sceneList.add("FXMLCalculator");
        sceneList.add("FXMLAbout");
    } 
    
    @FXML
    private void handleGoToCalculator(ActionEvent event) {
        switchTo(sceneList.get(1));
    }
    
    @FXML
    private void handleGoToAbout(ActionEvent event) {
        switchTo(sceneList.get(2));
    }
    
    @FXML
    private void inputSquared(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = num2 * num2;
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputCubed(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = num2 * num2 * num2;
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputSin(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = sin(num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputCos(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = cos(num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputTan(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = tan(num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputSquareRoot(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = sqrt(num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputTenToPowerX(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = pow(10, num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputEToPowerX(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double e = 2.718281828459045235360287471352662497757247093;

        Double num3 = pow(e, num2);
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputOneDividedByX(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = 1 / num2;
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    private void inputPi(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        Double pi = 3.14159265359;
        
        output.setText(pi.toString()); 
    }
   
}
