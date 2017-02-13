/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import java.util.UUID;


/**
 *
 * @author kiquetal
 */
@Data
public class Pagos {

     BigDecimal uuid;
     BigDecimal monto;
     Comercio comercio;
     Cliente client;
     Date operacion;
    
    

    
}
