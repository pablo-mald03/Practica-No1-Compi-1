package com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoMayorIgual extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoMayorIgual(NodoExpresion izq, NodoExpresion der) {
        izquierda = izq;
        derecha = der;
    }

    @Override
    public double evaluar(EntornoValores entorno) {
        return izquierda.evaluar(entorno) >= derecha.evaluar(entorno) ? 1 : 0;
    }
}