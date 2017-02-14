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
import me.cresterida.sparkjava.domain.Pagos;
import me.cresterida.sparkjava.domain.EmptyPagos;
import me.cresterida.sparkjava.exceptions.InsertException;
import me.cresterida.sparkjava.exceptions.NotFoundException;
import me.cresterida.sparkjava.services.impl.PagosServiciosImpl;
import me.cresterida.sparkjava.services.PagosServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

/**
 *
 * @author kiquetal
 */
public class PagosController {
    
       
    static Logger logger=LoggerFactory.getLogger(PagosController.class);
    
    
    public static MyMessage insertPago(Request r, Response rs)
    {
        MyMessage myMessage;
        Gson gson=new Gson();
        
        Pagos p1=gson.fromJson(r.body(), Pagos.class);
        
        rs.header("Content-Type", "application/json");
        PagosServices pg=new PagosServiciosImpl();
       
        boolean ok=false;
        try
        {
            pg.insertPago(p1);
            myMessage=new MySuccessMessage();
            Map<String,String> m=new HashMap<>();
            m.put("response", "ok");
            myMessage.setMessage(m);
        }
        catch (InsertException e)
        {
            rs.status(400);
              myMessage=new MyErrorMessage();
            Map<String,String> m=new HashMap<>();
            m.put("statusCode","400");
            m.put("errorMessage", e.toString());
            myMessage.setMessage(m);
        }
        catch(Exception ex)
        {
 
            rs.status(403);
            
            myMessage=new MyErrorMessage();
            Map<String,String> m=new HashMap<>();
            m.put("statusCode","403");
            m.put("errorMessage", ex.toString());
            myMessage.setMessage(m);
            logger.info(ex.toString());
            
        }
        return myMessage;
    }
    
    public static MyMessage getPago(Request req, Response res)
    
    {
        MyMessage msg;
        res.header("Content-type", "application/json");
        PagosServices pg=new PagosServiciosImpl();
        String pagosId=req.params(":pagosId");
        try
        {
            msg=new MySuccessMessage();
            Pagos p=pg.findPagos(Integer.valueOf(pagosId));
            
            if (p instanceof EmptyPagos)
                throw new NotFoundException("No se encontro registro con el id Proveido");
            Map<String,String>m=new HashMap<>();
            m.put("pago",p.toString());
            msg.<Pagos>setMessage(p);
        }
        catch (NotFoundException ex)
        {
            msg=new MyErrorMessage();
         Map<String,String>m=new HashMap<>();
         m.put("errorMessage",ex.toString());
         msg.setMessage(m);
         res.status(404);
        }
        catch(Exception ex)
        {
            
         msg=new MyErrorMessage();
         Map<String,String>m=new HashMap<>();
         m.put("errorMessage",ex.toString());
         msg.setMessage(m);
         res.status(500);
            
        }
        
        
        
        return msg;
        
        
    }
     public static MyMessage getAllPagos(Request r, Response res)
    {
        PagosServices pg=new PagosServiciosImpl();
     MyMessage msg;
     res.header("Content-Type", "application/json");
     try
     {
         msg=new MySuccessMessage();
         List<Pagos>l=pg.getAllPagos();
         System.out.println("from services");
         Map<String,List<Pagos>> m=new HashMap<>();
         m.put("pagos",l);
         msg.setMessage(m);
     }
     catch(Exception ex)
     {
         msg=new MyErrorMessage();
         Map<String,String>m=new HashMap<>();
         m.put("errorMessage",ex.toString());
         msg.setMessage(m);
         res.status(500);
     }
        
        
    return msg;   
    }
   

   
    
 
    
}
