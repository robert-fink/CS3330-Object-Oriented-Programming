/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbcalculator;


/**
 *
 * @author Robert Fink
 */
public class RwfwcbCalculatorController implements SimpleCalculator{
 
    @Override
    public Double calculate(Double x, Double y, String operator){
        switch(operator){
            case "+": return x + y;
            case "-": return x - y;
            case "x": return x * y;
            case "/": return x / y;
        }
        System.out.println("Unknown operator" + operator);
        return 0.0;
    }

    
}
