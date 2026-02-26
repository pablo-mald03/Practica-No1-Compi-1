package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;

public class NodoDeclaracion extends NodoSimple {

    private String nombre;
    private NodoExpresion expresion;

    public NodoDeclaracion(String nombre, NodoExpresion expresion){
        this.nombre = nombre;
        this.expresion = expresion;
    }

    //Metodo que permite obtener el texto que hay dentro
    @Override
    public String getString() {
        return  "VAR "+ this.nombre +" = "+ expresion.getString();
    }


}
