/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.cresterida.sparkjava;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 *
 * @author kiquetal
 */
public class JSONTransformer implements ResponseTransformer {

    private final Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }   

}
