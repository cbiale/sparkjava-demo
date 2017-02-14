/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.controllers;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.cresterida.sparkjava.MyErrorMessage;
import me.cresterida.sparkjava.MyMessage;
import me.cresterida.sparkjava.MySuccessMessage;
import me.cresterida.sparkjava.domain.Comercio;
import me.cresterida.sparkjava.services.ComercioServices;
import me.cresterida.sparkjava.services.impl.ComercioServicesImpl;
import spark.Request;
import spark.Response;

/**
 *
 * @author kiquetal
 */
public class ComercioController {
 
    
    
    public static MyMessage insertComercio(Request req,Response rs)
    {
        
         MyMessage msg;
        Gson gson=new Gson();
        ComercioServices cm=new ComercioServicesImpl();
        boolean ok=false;
        try
        {
            Comercio c=gson.fromJson(req.body(), Comercio.class);
            
            ok=cm.addComercio(c);
                        msg=new MySuccessMessage();

            if (ok)
            {
            Map<String,String>ls=new HashMap<>();
            ls.put("response", "Comercio agregado de forma exitosa");
            msg.setMessage(ls);
            }
            
        }
        catch(Exception ex)
        {
            rs.status(500);
            msg=new MyErrorMessage();
            Map<String,String>m=new HashMap<>();
            m.put("messageError",ex.toString());
            msg.setMessage(m);
        }
        
        
        return msg;
        
        
        
    }
    
    public static MyMessage getAllComercio(Request req,Response rs)
    {
        MyMessage msg;
        
        ComercioServices cm=new ComercioServicesImpl();
        
        try
        {
            
            List<Comercio> lis=cm.getAllComercios();
            
            msg=new MySuccessMessage();
            Map<String,List<Comercio>>ls=new HashMap<>();
            ls.put("comercios", lis);
            msg.setMessage(ls);
            
            
        }
        catch(Exception ex)
        {
            rs.status(500);
            msg=new MyErrorMessage();
            Map<String,String>m=new HashMap<>();
            m.put("messageError",ex.toString());
            msg.setMessage(m);
        }
        
        
        return msg;
        
        
    }
}
