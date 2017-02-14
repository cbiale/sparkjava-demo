/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


/**
 *
 * @author kiquetal
 */
@Data
public class Pagos {

     BigDecimal id;
     BigDecimal monto;
     Comercio comercio;
     Cliente client;
     Date operaction;
     String comercio_id;
     String cliente_id;
    
    @Override
    public String toString()
    {
        return "id"+this.id+"monto"+this.monto+"comercio_id"+this.comercio_id+" cliente_id"+this.cliente_id;
    }

    
}
