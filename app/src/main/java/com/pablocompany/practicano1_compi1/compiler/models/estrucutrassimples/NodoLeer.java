package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.expresiones.NodoVariable;

public class NodoLeer extends NodoSimple {

    private NodoExpresion expresion;

    public NodoLeer(String expresion, int linea, int columna) {
        this.expresion = new NodoVariable(expresion, linea, columna);
    }

    //====Metodos getter====
    public NodoExpresion getExpresion() {
        return expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {
        double valor = expresion.evaluar(entorno);
    }

    @Override
    public String getString() {
        return "LEER " + this.expresion.getString();
    }

    /*P*/
}
