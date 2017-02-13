/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.controllers;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import me.cresterida.sparkjava.MyErrorMessage;
import me.cresterida.sparkjava.MyMessage;
import me.cresterida.sparkjava.MySuccessMessage;
import me.cresterida.sparkjava.domain.Cliente;
import me.cresterida.sparkjava.services.ClienteServices;
import me.cresterida.sparkjava.services.impl.ClienteServicesImpl;
import spark.Request;
import spark.Response;

/**
 *
 * @author kiquetal
 */
public class ClienteController {
    public static MyMessage insertCliente(Request re,Response res)
    {
        MyMessage msg;
        res.header("Content-Type", "application/json");
        Gson g=new Gson();
        Cliente c= g.fromJson(re.body(), Cliente.class);
        ClienteServices cs=new ClienteServicesImpl();
        try
        {
            cs.addCliente(c);
            msg=new MySuccessMessage();
            Map<String,String> map=new HashMap<>();
            map.put("message", "Cliente agregado de forma exitosa");
            msg.setMessage(map);
        }
        catch(Exception ex)
        {
            msg=new MyErrorMessage();
            Map<String,String> todo=new HashMap<>();
            todo.put("errorMessage",ex.toString());
            msg.setMessage(todo);
            res.status(403);
            
        }
        
     return msg;
    }
    
    public boolean existingClient(Cliente c)
    {
     
        return false;
    }
    public Map<Cliente,String> getAllClientes()
    {
        return null;
    }
}
