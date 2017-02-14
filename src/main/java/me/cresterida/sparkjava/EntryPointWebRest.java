/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava;
import java.io.IOException;
import me.cresterida.sparkjava.controllers.ClienteController;
import me.cresterida.sparkjava.controllers.ComercioController;
import me.cresterida.sparkjava.controllers.PagosController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import static spark.Spark.*;
/**
 *
 * @author kiquetal
 */
public class EntryPointWebRest {
    static Logger logger=LoggerFactory.getLogger(EntryPointWebRest.class);
   
   
    
    public static void main(String[] args) throws IOException {
    
        
        
        Spark.exception(Exception.class, (exception, request, response) -> {
    exception.printStackTrace();
});
   

          get("/clientes",ClienteController::getAllClientes,new JSONTransformer());  
          get("/comercios",ComercioController::getAllComercio,new JSONTransformer());  
       
          post("/comercios",ComercioController::insertComercio,new JSONTransformer());
          post("/clientes","application/json",ClienteController::insertCliente,new JSONTransformer());
          get("/pagos",PagosController::getAllPagos,new JSONTransformer()); 
          post("/pagos","application/json",PagosController::insertPago,new JSONTransformer());
          get("/pagos/:pagosId",PagosController::getPago,new JSONTransformer()); 
          get("/clientes/:clienteId",ClienteController::getCliente,new JSONTransformer()); 


          get("/dame/*", (request, response) -> {
                    
             return "dame";
          });
          get("/dame", (request, response) -> {
             return "dame";
          });
          get("*", (request, response) -> {
                    
             System.out.println("404 not found!!");
             return "not found";
         });
    }
}

