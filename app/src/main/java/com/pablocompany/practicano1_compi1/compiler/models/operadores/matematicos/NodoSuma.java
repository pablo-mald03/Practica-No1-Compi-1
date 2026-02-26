package com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoSuma extends NodoExpresion {

    private NodoExpresion izquierda;
    private NodoExpresion derecha;

    public NodoSuma(NodoExpresion izquierda, NodoExpresion derecha, int fila, int columna){
        super(fila,columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }


    //Metodo que permite obtener su valor como string
    @Override
    public String getString() {
        return "(" + izquierda.getString() + " + " + derecha.getString() + ")";
    }

    //Metodos que permiten obtener los valores numericos procesados de las instrucciones
    @Override
    public int getValorEntero() {
        return this.izquierda.getValorEntero() + this.derecha.getValorEntero();
    }

    @Override
    public double getValorDecimal() {
        return this.izquierda.getValorDecimal() + this.derecha.getValorDecimal();
    }
}
