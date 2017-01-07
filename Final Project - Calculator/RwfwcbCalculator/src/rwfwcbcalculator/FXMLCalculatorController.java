/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbcalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Robert Fink
 */
public class FXMLCalculatorController extends Switchable implements Initializable {   
    
    @FXML
    TextField output;
    
    String operator = "";
    
    Double num1 = 0.0;
    
    Answer answer;
        
    final RwfwcbCalculatorController simpleCalc = new RwfwcbCalculatorController();
    
    boolean start = true;
    
    boolean decimalSet = false;
    
    private Stage stage;
    
    ArrayList<String> sceneList;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        answer = new Answer();
        sceneList = new ArrayList();
        sceneList.add("FXMLScientificCalculator");
        sceneList.add("FXMLCalculator");
        sceneList.add("FXMLAbout");
    } 
    
    @FXML
    private void inputNumpad(ActionEvent event){
        String decimalFlag = output.getText();
        
        if (decimalFlag.equals(".")){
            start = false;
        }
        
        if (start){
            output.setText("");
            start = false;
        }
        
        String digit = ((Button) event.getSource()).getText();
        String oldDigit = output.getText();
        String newDigit = oldDigit + digit;
       
        output.setText(newDigit);  
    }
    
    @FXML
    private void inputOperator(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        decimalSet = false;
        
        String input = ((Button)event.getSource()).getText();        
        
        if (!input.equals("=")){
           operator = input;
           num1 = Double.parseDouble(output.getText());
           output.setText("");
        } else {
            if (operator.isEmpty()){
                return;
            }
        }
        
        if (input.equals("=")){
            output.setText(String.valueOf(simpleCalc.calculate(num1, Double.parseDouble(output.getText()), operator)));
            operator="";
            start = true;
            decimalSet = false;
        }
        
    }
    
    @FXML
    private void inputClear(ActionEvent event){
        output.setText(""); 
        start = true;
        decimalSet = false;
    }
    
    @FXML
    private void inputDecimal(ActionEvent event){
        
        if (decimalSet == true){
            return;
        }
        
        String digit = output.getText();
        output.setText(digit + "."); 
        decimalSet = true;
    }
    
    @FXML
    private void inputPercent(ActionEvent event){
        
        if (output.getText().isEmpty()){
            return;
        }
        
        String num = output.getText();
        
        Double num2 = Double.valueOf(num);
        
        Double num3 = num2 / 100;
                
        output.setText(num3.toString()); 
    }
    
    @FXML
    public void handleOpen(ActionEvent event) {
        Answer answer = createAnswerFromFormData();       
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try{
                FileReader fileReader = new FileReader(file.getPath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
 
                String json = "";
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    json += line;
                }
                bufferedReader.close();
                fileReader.close();
                
                answer.initFromJsonString(json);
               
                fillFormFromAnswer(answer);
            }catch(IOException ioex)
            {
               String message = "Exception occurred while opening " + file.getPath();
               displayErrorAlert(message);
            }
        }
    }
    
    @FXML
    public void handleSave(ActionEvent event) {
        answer = createAnswerFromFormData();
        if (answer == null) {
            return;
        }
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try{
               String jsonString = answer.toJsonString();
               PrintWriter out = new PrintWriter(file.getPath());
               out.print(jsonString);
               out.close();
            }catch(IOException ioex)
            {
                String message = "Exception occurred while saving to " + file.getPath();
                displayErrorAlert(message);
            } 
        }        
    }
    
    private void fillFormFromAnswer(Answer Answer) {  
        if (answer.getAnswer() != null) {
            output.setText(answer.getAnswer());
        } else {
            output.setText("");
        }
    }
    
    
    private Answer createAnswerFromFormData() {
        Answer a = new Answer();
        
        a.setAnswer(output.getText());
        
        return a;
    }
    
    private void displayErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void handleGoToScientificCalculator(ActionEvent event) {
        switchTo(sceneList.get(0));
    }
    
    @FXML
    private void handleGoToAbout(ActionEvent event) {
        switchTo(sceneList.get(2));
    }
   
}
