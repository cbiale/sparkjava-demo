/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sql2o.Sql2o;
import spark.resource.ClassPathResource;

/**
 *
 * @author kiquetal
 */
public class UtilDB {
   
    private static final String MYSQL_URL="MYSQL_URL";
    private static final String MYSQL_USER="MYSQL_USER";
    private static final String MYSQL_PASSWORD="MYSQL_PASSWORD";
    public static Sql2o getDatabase = obtainConnection();

    static Sql2o obtainConnection()
    {
        System.out.println("only one");
        try {
            return new Sql2o(getProperties(MYSQL_URL),getProperties(MYSQL_USER),getProperties(MYSQL_PASSWORD));
        } catch (IOException ex) {
            Logger.getLogger(UtilDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    static String getProperties(String property) throws IOException
    {
        
        String toReturn=null;
         ClassPathResource resource=new ClassPathResource("mysql.properties");
         Properties properties = new Properties();
         InputStream stream = null;
        try {
            stream = resource.getInputStream();
            properties.load(stream);
           
            
           // return properties;
        } finally {
            if (stream!=null)
            stream.close();
        }
        
        switch(property)
        {
            
            case MYSQL_URL:
                toReturn=properties.getProperty(property);
                break;
            case MYSQL_USER:
                toReturn=properties.getProperty(property);
                break;
            case MYSQL_PASSWORD:
                toReturn=properties.getProperty(property);
                break;
            default:
                toReturn= "not found";
                break;
        }
        
        return toReturn;
    }
}
