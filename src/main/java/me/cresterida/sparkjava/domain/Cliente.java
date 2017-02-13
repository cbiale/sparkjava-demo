/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.domain;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author kiquetal
 */
@Data
public class Cliente {
     BigDecimal id;
     String name;
     String ci;
     
     @Override
     public boolean equals(Object o)
     {
         if (o==null) return false;
         if (o==this)
             return true;
         if (getClass()!=o.getClass())
             return false;
         Cliente c=(Cliente) o;
         return (Objects.equals(ci, c.getCi()));
             
         
     }
}
