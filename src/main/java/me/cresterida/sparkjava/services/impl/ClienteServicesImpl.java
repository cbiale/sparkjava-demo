/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services.impl;

import java.util.List;
import me.cresterida.sparkjava.domain.Cliente;
import me.cresterida.sparkjava.exceptions.DuplicateClienteException;
import me.cresterida.sparkjava.services.ClienteServices;
import me.cresterida.sparkjava.util.UtilDB;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author kiquetal
 */
public class ClienteServicesImpl implements ClienteServices{

    @Override
    public List<Cliente> getAllClients() {
         List<Cliente>list;
                Sql2o sql2=UtilDB.getDatabase;
        try(Connection con=sql2.open())
        {
            list=  con.createQuery("SELECT * FROM CLIENTES")
                         .executeAndFetch(Cliente.class);
            
                            
        }
        
        return list;



    }

    @Override
    public Cliente findCliente(String uuid) {

        return null;

    }

    @Override
    public boolean addCliente(Cliente c) {
           boolean ok=false;
           Sql2o sql2=UtilDB.getDatabase;
           
         if (existsClient(c))
         {
             throw new DuplicateClienteException("Usuario con RUC existente!!!");
         }
         
         System.out.println("to insert" + c);
           
        try(Connection con=sql2.open())
        {
              con.createQuery("INSERT INTO CLIENTES (name,ci) VALUES(:name,:ci)")
                      .addParameter("name", c.getName())
                      .addParameter("ci", c.getCi())
                      .executeUpdate();
            
                            
        }
      
        return ok;
        


    }

    @Override
    public boolean removeCliente(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsClient(Cliente c) {
        List<Cliente> lista=getAllClients();
        System.out.println( lista.contains(c));
        return lista.contains(c);

    }
    
}
