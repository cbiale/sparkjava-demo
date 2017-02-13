/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import me.cresterida.sparkjava.controllers.ClienteController;
import me.cresterida.sparkjava.controllers.PagosController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import static spark.Spark.*;
import spark.resource.ClassPathResource;
/**
 *
 * @author kiquetal
 */
public class TestingSpark {
    static Logger logger=LoggerFactory.getLogger(TestingSpark.class);
   
   
    
    public static void main(String[] args) throws IOException {
     Spark.exception(Exception.class, (exception, request, response) -> {
    exception.printStackTrace();
});
   
      
          get("/clientes",ClienteController::getAllClientes,new JSONTransformer());  
          post("/clientes","application/json",ClienteController::insertCliente,new JSONTransformer());
          get("/pagos","application/json",PagosController::insertPago,new JSONTransformer());        
    }
}

