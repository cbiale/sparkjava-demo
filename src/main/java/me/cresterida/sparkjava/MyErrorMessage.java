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
public final class MyErrorMessage implements MyMessage{
    
    private String message;    
    private Map<String,String> error=new HashMap<>();

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    public MyErrorMessage(String message)
    {
        setMessage(message);
    }
    public MyErrorMessage()
    {
        
    }

    /**
     * @param message the message to set
     */
    
    @Override
    public void setMessage(Map m)
    {
        this.error=m;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public <T> void setMessage(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
