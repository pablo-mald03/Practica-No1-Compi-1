package com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoSuma extends NodoExpresion {

    private NodoExpresion izquierda;
    private NodoExpresion derecha;

    public NodoSuma(NodoExpresion izquierda, NodoExpresion derecha, int fila, int columna){
        super(fila,columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public double evaluar(EntornoValores entorno){
        return izquierda.evaluar(entorno)
                + derecha.evaluar(entorno);
    }

    @Override
    public String getString() {
        return "(" + izquierda.getString() + " + " + derecha.getString() + ")";
    }
}
