/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import me.cresterida.sparkjava.domain.EmptyPagos;
import me.cresterida.sparkjava.domain.Pagos;
import me.cresterida.sparkjava.exceptions.InsertException;
import me.cresterida.sparkjava.services.PagosServices;
import me.cresterida.sparkjava.util.UtilDB;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author kiquetal
 */
public class PagosServiciosImpl implements PagosServices{

    
    
    
    
    @Override
    public List<Pagos> getAllPagos() {
        

        
        
        List<Pagos>list;
                Sql2o sql2=UtilDB.getDatabase;
        try(Connection con=sql2.open())
        {
            list=  con.createQuery("SELECT * FROM PAGOS")
                         .executeAndFetch(Pagos.class);
            
            System.out.println(list);
            
                            
        }
        
        return list;
        
        
    }

    @Override
    public List<Pagos> getAllPagosByUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean insertPagosCollection(List<Pagos> pagos)
    {
        try
        {
            
        pagos.forEach( (pago)->
        {
                insertPago(pago);
        }
        );
        }
        catch(Exception ex)
        {
            return false;
        }
              
        return true;
   }
    
    @Override
    public boolean insertPago(Pagos pago) {
        
        
        Sql2o sql2=UtilDB.getDatabase;
        System.out.println(pago.getClient());
        try(Connection con=sql2.open())
        {
            con.createQuery("INSERT INTO PAGOS (comercio_id,cliente_id,monto,operaction)"
                    + "VALUES (:comercio_id,:cliente_id,:monto,:operaction)")
                    .addParameter("cliente_id",pago.getCliente_id())
                    .addParameter("comercio_id",pago.getComercio_id())
                    .addParameter("monto",pago.getMonto())
                    .addParameter("operaction", new Date())
                    .executeUpdate();
                               
            
                            
        }
        catch(Exception ex)
        {
            throw new InsertException(ex.getMessage());
        }
        
        return true;
        
    }

    @Override
    public boolean deletePagos(Pagos pagos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Pagos findPagos(int pagosId) {

       List<Pagos> l=getAllPagos();
       System.out.println("buscando"+pagosId);
       Stream<Pagos> s=l.stream().filter(p-> p.getId().intValue()==pagosId);
      return s.findFirst().orElseGet(()-> new EmptyPagos());
    }
    
}
