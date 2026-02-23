package com.pablocompany.practicano1_compi1.compiler.models;

import java.util.HashMap;
import java.util.Map;

public class EntornoValores {
    private Map<String, Double> variables = new HashMap<>();

    public void setVariable(String nombre, double valor){
        variables.put(nombre, valor);
    }

    public double getVariable(String nombre){
        if(!variables.containsKey(nombre)){
            return 0; // o lanzar error
        }
        return variables.get(nombre);
    }
}
