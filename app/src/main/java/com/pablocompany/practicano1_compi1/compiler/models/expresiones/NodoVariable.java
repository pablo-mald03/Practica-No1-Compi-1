package com.pablocompany.practicano1_compi1.compiler.models.expresiones;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

/*P*/
//Clase que representa un valor de variable
public class NodoVariable extends NodoExpresion {

    private String nombre;

    public NodoVariable(String nombre, int fila, int columna){
        super(fila,columna);
        this.nombre = nombre;
    }

    @Override
    public double evaluar(EntornoValores entorno){
        return entorno.getVariable(nombre);
    }

    @Override
    public String getString() {
        return this.nombre;
    }
}
