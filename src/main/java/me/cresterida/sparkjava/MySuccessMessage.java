/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kiquetal
 */
public class MySuccessMessage implements MyMessage{

private String message;    
private Map<String,String> response=new HashMap<>();

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    public MySuccessMessage(String message)
    {
        setMessage(message);
    }
    public MySuccessMessage()
    {
        
    }

    /**
     * @param message the message to set
     */
    
@Override
    public void setMessage(Map m)
    {
        this.response=m;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
