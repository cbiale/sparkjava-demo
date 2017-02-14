/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava.services;

import java.util.List;
import me.cresterida.sparkjava.domain.Cliente;

/**
 *
 * @author kiquetal
 */
public interface ClienteServices {
    List<Cliente> getAllClients();
    Cliente findCliente(int uuid);
    boolean addCliente(Cliente c);
    boolean removeCliente(Cliente c);
    boolean existsClient(Cliente c);
}
