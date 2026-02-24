package com.pablocompany.practicano1_compi1.compiler.models;
/*P*/

import java.util.HashMap;
import java.util.Map;

//Clase que permite obtener el valor de la variable con su valor numerico (Restriccion del proyecto)
public class EntornoValores {
    private Map<String, Double> variables;

    public EntornoValores() {
        variables = new HashMap<>();
    }

    public void setVariable(String nombre, double valor) {
        variables.put(nombre, valor);
    }

    public double getVariable(String nombre) {
        if (!variables.containsKey(nombre)) {
            return 0;
        }
        return variables.get(nombre);
    }
}
