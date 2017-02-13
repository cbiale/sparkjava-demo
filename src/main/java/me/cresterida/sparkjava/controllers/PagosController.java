/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import me.cresterida.sparkjava.MyErrorMessage;
import me.cresterida.sparkjava.MyMessage;
import me.cresterida.sparkjava.MySuccessMessage;
import me.cresterida.sparkjava.domain.Cliente;
import me.cresterida.sparkjava.domain.Pagos;
import me.cresterida.sparkjava.domain.Comercio;
import me.cresterida.sparkjava.services.impl.PagosServiciosImpl;
import me.cresterida.sparkjava.services.PagosServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.http.matching.Halt;

/**
 *
 * @author kiquetal
 */
public class PagosController {
    
       
    static Logger logger=LoggerFactory.getLogger(PagosController.class);
    
    
    public static MyMessage insertPago(Request r, Response rs)
    {
        MyMessage myMessage;
        PagosServices pg=new PagosServiciosImpl();
        Pagos p=new Pagos();
        Cliente c=new Cliente();
        c.setId(new BigDecimal("1231"));
        c.setCi("1231");
        c.setName("Julian");
        p.setClient(c);
        Comercio co=new Comercio();
        co.setLogo(null);
        co.setName("PROCARD");
        co.setId(BigDecimal.ZERO);
        p.setComercio(co);
        p.setMonto(new BigDecimal("1222"));
        boolean ok=false;
        try
        {
            pg.insertPago(p);
            myMessage=new MySuccessMessage();
            Map<String,String> m=new HashMap<>();
            m.put("response", "ok");
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
    
   public static Pagos getAllPagos(Request r, Response res)
    {
        PagosServices pg=new PagosServiciosImpl();
        System.out.println(pg);
        
        
    return null;   
    }
    
 
    
}
