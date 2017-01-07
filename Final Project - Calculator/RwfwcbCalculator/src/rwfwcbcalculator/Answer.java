/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcbcalculator;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.Serializable;


/**
 *
 * @author Robert Fink
 */
public class Answer implements Serializable {
    
    private String answer = "";
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public String toJsonString() {
        JSONObject obj=new JSONObject();
        
        if (answer != null) obj.put("answer", answer);
        
        return obj.toJSONString(); 
    }
    
    public void initFromJsonString(String jsonString) {
        answer = "";
        
        if (jsonString == null || jsonString == "") return;
        
        JSONObject jsonObj;
        
        try {
            jsonObj = (JSONObject)JSONValue.parse(jsonString);
        } catch (Exception ex) {
            return;
        }
        
        if (jsonObj == null) {
            return;
        }
                
        // get on a number will be a long
        Object answer = jsonObj.getOrDefault("answer", null);
        
        if (answer != null) {
            if (answer instanceof Long) {
                Long longAnswer = (Long)answer;
                answer = new Double(longAnswer.doubleValue());
            } else {
                answer = null;
            } 
        }
    }
    
}
