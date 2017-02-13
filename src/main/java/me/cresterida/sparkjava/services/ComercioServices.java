/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services;

import java.util.List;
import me.cresterida.sparkjava.domain.Comercio;

/**
 *
 * @author kiquetal
 */
public interface ComercioServices {
    List<Comercio> getAllComercios();
    boolean addComercio(Comercio c);
    boolean deleteComercio(Comercio c);
    Comercio findComercio(String name);
    
    
}
