package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoOr extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoOr(NodoExpresion izq, NodoExpresion der) { izquierda = izq; derecha = der; }
    @Override
    public double evaluar(EntornoValores entorno) {
        return (izquierda.evaluar(entorno) != 0 || derecha.evaluar(entorno) != 0) ? 1 : 0;
    }
}

