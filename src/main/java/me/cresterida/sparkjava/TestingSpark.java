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
   
    private static final String PROPERTIES = "mysql.properties";

    
    public static void loadFromProperties(){
        System.out.println("lectura");
		loadFromProperties(new File( "/resources/"+PROPERTIES));
	}
    public static void loadFromProperties( File f){
        System.out.println("read from");
		Properties properties = new Properties();
		try {
			if(f.exists() && f.isFile()){
				logger.debug("Loading configuration from properties file... " + f.getPath());
			    properties.load(new FileInputStream(f));
                            System.out.println("a"+properties.toString());
				logger.debug("Found properties: " + properties.toString());
			
			}
                        else
                        {
                            System.out.println("Not exists" + f.getCanonicalPath());
                        }
		} catch (IOException e) {
			System.out.println("Unable to read properties file '");
		}
	}
    
    
    public static void main(String[] args) throws IOException {
     Spark.exception(Exception.class, (exception, request, response) -> {
    exception.printStackTrace();
});
   
      
          post("/clientes","application/json",ClienteController::insertCliente,new JSONTransformer());
          get("/pagos","application/json",PagosController::insertPago,new JSONTransformer());        
    }
}

