/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services;

import java.util.List;
import me.cresterida.sparkjava.domain.Pagos;
import me.cresterida.sparkjava.exceptions.InsertException;

/**
 *
 * @author kiquetal
 */
public interface PagosServices {
    
    List<Pagos> getAllPagos();
    List<Pagos> getAllPagosByUser(String userId);
    boolean insertPago(Pagos pagos);
    boolean deletePagos(Pagos pagos);
    Pagos findPagos(int pagosId);
    
    
}
