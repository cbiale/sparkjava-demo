/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services.impl;

import java.util.List;
import java.util.stream.Stream;
import me.cresterida.sparkjava.domain.Cliente;
import me.cresterida.sparkjava.domain.Comercio;
import me.cresterida.sparkjava.domain.EmptyComercio;
import me.cresterida.sparkjava.services.ComercioServices;
import me.cresterida.sparkjava.util.UtilDB;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author kiquetal
 */
public class ComercioServicesImpl implements ComercioServices{

    @Override
    public List<Comercio> getAllComercios() {

   List<Comercio>list;
                Sql2o sql2=UtilDB.getDatabase;
        try(Connection con=sql2.open())
        {
            list=  con.createQuery("SELECT * FROM COMERCIOS")
                         .executeAndFetch(Comercio.class);
            
                            
        }
        
        return list;

    }

    @Override
    public boolean addComercio(Comercio c) {

  boolean ok=false;
           Sql2o sql2=UtilDB.getDatabase;
           
         
         System.out.println("to insert" + c);
           
        try(Connection con=sql2.open())
        {
              con.createQuery("INSERT INTO COMERCIOS (name,logo) VALUES(:name,:logo)")
                      .addParameter("name", c.getName())
                      .addParameter("logo", c.getLogo())
                      .executeUpdate();
            ok=true;
                            
        }
      
        return ok;



    }

    @Override
    public boolean deleteComercio(Comercio c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comercio findComercio(String name) {

        List<Comercio> lista=getAllComercios();
        Stream<Comercio> stm=lista.stream().filter(c -> c.getName().equals(name));
        return stm.findFirst().orElseGet(()-> new EmptyComercio());



    }
    
}
