package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;

public class NodoMostrarCadena extends NodoSimple {

    private String expresion;

    public NodoMostrarCadena(String expresion) {
        this.expresion = expresion;
    }

    @Override
    public String getString() {
        return "MOSTRAR " + "\" " + this.expresion  + " \"";
    }
}