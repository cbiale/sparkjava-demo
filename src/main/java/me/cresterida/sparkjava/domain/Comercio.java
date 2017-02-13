/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.domain;

import com.google.common.base.Objects;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author kiquetal
 */

@Data
public class Comercio {
     String name;
     BigDecimal id;
     String logo;
    
     
     @Override
     public boolean equals(Object o)
     {
         if (o==null) return false;
         if (o == this)
             return true;
    
         if (getClass()!=o.getClass())
         {
             return false;
         }
         Comercio co=(Comercio) o;
         return Objects.equal(name,  co.name) ;
         
     }
     @Override
     public int hashCode()
     {
         return 31*name.length()+id.intValue();
     }
}
