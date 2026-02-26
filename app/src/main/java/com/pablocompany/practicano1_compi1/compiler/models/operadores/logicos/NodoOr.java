package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoOr extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoOr(NodoExpresion izq, NodoExpresion der, int linea, int columna)
    {
        super(linea, columna);
        izquierda = izq;
        derecha = der;
    }

    /*===Metodos getters utilizados para poder obtener las expresiones===*/
    public NodoExpresion getDerecha() {
        return derecha;
    }

    public NodoExpresion getIzquierda() {
        return izquierda;
    }
    /*===Metodos getters utilizados para poder obtener las expresiones===*/

    //Metodo que retorna su valor como string
    @Override
    public String getString() {
        return this.izquierda.getString() + " || " + this.derecha.getString();
    }

    //Metodos que permiten obtener los valores numericos procesados de las instrucciones
    @Override
    public int getValorEntero() {
        return 0;
    }

    @Override
    public double getValorDecimal() {
        return 0;
    }
}

